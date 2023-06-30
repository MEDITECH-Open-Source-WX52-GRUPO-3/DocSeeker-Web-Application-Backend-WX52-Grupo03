package com.meditech.healthapp.DockSeeker.healing.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Doctor;
import com.meditech.healthapp.DockSeeker.healing.domain.presistence.DoctorRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.service.DoctorService;
import com.meditech.healthapp.DockSeeker.shared.exception.ResourceNotFoundException;
import com.meditech.healthapp.DockSeeker.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
    private static final String ENTITY = "Doctor";
    private DoctorRepository doctorRepository;
    private final Validator validator; //jakarta.validation.validator no confundir

    public DoctorServiceImpl(DoctorRepository doctorRepository, Validator validator){
        this.doctorRepository = doctorRepository;
        this.validator = validator;
    }

    @Override
    public List<Doctor> getAll() { return doctorRepository.findAll();}

    @Override
    public Doctor getById(Long newId) {
        return doctorRepository.findById(newId).
                orElseThrow(()->new ResourceNotFoundException(ENTITY,newId));
    }

    @Override
    public Page<Doctor> getAll(Pageable pageable){ return doctorRepository.findAll(pageable); }

    @Override
    public Doctor create(Doctor doctor){
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        Doctor doctorWithDni = doctorRepository.findByDni(doctor.getDni());

        if(doctorWithDni != null)
            throw new ResourceValidationException(ENTITY,"AN doctor with the same dni already exits");

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long doctorId, Doctor request){
        Set<ConstraintViolation<Doctor>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Validation --> Dni
        Doctor doctorWithDni = doctorRepository.findByDni(request.getDni());
        if(doctorWithDni != null && !doctorWithDni.getId().equals(doctorId))
            throw new ResourceValidationException(ENTITY,"AN doctor with the same dni already exits");

        return doctorRepository.findById(doctorId).map(doctor ->
                        doctorRepository.save(doctor
                                .withName(request.getName())
                                .withDni(request.getDni())
                                .withGenre(request.getGenre())
                                .withPassword(request.getPassword())
                                .withPhoto(request.getPhoto())
                                .withArea(request.getArea())
                                .withDescription(request.getDescription())
                                .withPatients(request.getPatients())
                                .withYears(request.getYears())
                                .withCost(request.getCost())
                                .withAge(request.getAge())
                                .withEducation(request.getEducation())
                                .withHoursAvailable(request.getHoursAvailable())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,doctorId));
    }


    @Override
    public ResponseEntity<?> delete(Long doctorId) {
        return doctorRepository.findById(doctorId).map(doctor->{
            doctorRepository.delete(doctor);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, doctorId));
    }
}
