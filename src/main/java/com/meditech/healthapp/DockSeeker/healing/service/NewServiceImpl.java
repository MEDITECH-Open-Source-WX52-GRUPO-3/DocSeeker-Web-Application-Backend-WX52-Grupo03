package com.meditech.healthapp.DockSeeker.healing.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import com.meditech.healthapp.DockSeeker.healing.domain.presistence.NewRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.service.NewService;

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
public class NewServiceImpl implements NewService {

    private static final String ENTITY = "New";
    private NewRepository newRepository;
    private final Validator validator; //jakarta.validation.validator no confundir

    public NewServiceImpl(NewRepository newRepository, Validator validator){
        this.newRepository = newRepository;
        this.validator = validator;
    }

    @Override
    public List<New> getAll() {
        return newRepository.findAll();
    }

    @Override
    public New getById(Long newId) {
        return newRepository.findById(newId).
                orElseThrow(()->new ResourceNotFoundException(ENTITY,newId));
    }

    @Override
    public Page<New> getAll(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public New create(New newapp) {

        Set<ConstraintViolation<New>> violations = validator.validate(newapp);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }
        //Name Uniques Validation
        New newWithName = newRepository.findByTitle(newapp.getTitle());

        if(newWithName != null)
            throw new ResourceValidationException(ENTITY,"AN new with the same name already exits");

        return newRepository.save(newapp);

    }

    @Override
    public New update(Long newId, New request) {

        //Violation
        Set<ConstraintViolation<New>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Validation --> Name
        New newWithName = newRepository.findByTitle(request.getTitle());
        if(newWithName != null && !newWithName.getId().equals(newId))
            throw new ResourceValidationException(ENTITY,
                    "An New with the same title already exits.");

        return newRepository.findById(newId).map(newapp ->
                newRepository.save(newapp
                        .withTitle(request.getTitle())
                        .withImage(request.getImage())
                        .withDescription(request.getDescription())
                        .withInfo(request.getInfo())
                        .withViews(request.getViews())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,newId));

    }

    @Override
    public ResponseEntity<?> delete(Long newId) {
        return newRepository.findById(newId).map(newapp->{
            newRepository.delete(newapp);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, newId));
    }
}
