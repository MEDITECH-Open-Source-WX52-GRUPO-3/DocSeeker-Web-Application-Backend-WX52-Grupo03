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
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long newId) {
        return null;
    }
}
