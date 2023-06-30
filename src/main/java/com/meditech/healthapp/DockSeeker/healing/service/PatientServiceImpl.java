package com.meditech.healthapp.DockSeeker.healing.service;


import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Patient;
import com.meditech.healthapp.DockSeeker.healing.domain.presistence.PatientRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.service.PatientService;
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
public class PatientServiceImpl implements PatientService {
    private static final String ENTITY = "Patient";
    private PatientRepository patientRepository;
    private final Validator validator; //jakarta.validation.validator no confundir

    public PatientServiceImpl(PatientRepository patientRepository, Validator validator){
        this.patientRepository = patientRepository;
        this.validator = validator;
    }

    @Override
    public List<Patient> getAll() { return patientRepository.findAll();}

    @Override
    public Patient getById(Long newId) {
        return patientRepository.findById(newId).
                orElseThrow(()->new ResourceNotFoundException(ENTITY,newId));
    }

    @Override
    public Page<Patient> getAll(Pageable pageable){ return patientRepository.findAll(pageable); }

    @Override
    public Patient create(Patient patient){
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        Patient patientWithDni = patientRepository.findByDni(patient.getDni());

        if(patientWithDni != null)
            throw new ResourceValidationException(ENTITY,"AN patient with the same dni already exits");

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Long patientId, Patient request){
        Set<ConstraintViolation<Patient>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Validation --> Dni
        Patient patientWithDni = patientRepository.findByDni(request.getDni());
        if(patientWithDni != null && !patientWithDni.getId().equals(patientId))
            throw new ResourceValidationException(ENTITY,"AN patient with the same dni already exits");

        return patientRepository.findById(patientId).map(patient ->
                patientRepository.save(patient
                        .withName(request.getName())
                        .withDni(request.getDni())
                        .withEmail(request.getEmail())
                        .withGenre(request.getGenre())
                        .withBirthday(request.getBirthday())
                        .withCellphone(request.getCellphone())
                        .withPassword(request.getPassword())
                        .withPhoto(request.getPhoto())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,patientId));
    }


    @Override
    public ResponseEntity<?> delete(Long patientId) {
        return patientRepository.findById(patientId).map(patient->{
            patientRepository.delete(patient);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
    }

}
