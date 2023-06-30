package com.meditech.healthapp.DockSeeker.healing.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Date;

import com.meditech.healthapp.DockSeeker.healing.domain.presistence.DateRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.presistence.NewRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.service.DateService;
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
public class DateServiceImpl implements DateService {

    private static final String ENTITY = "Date";
    private DateRepository dateRepository;
    private final Validator validator; //jakarta.validation.validator no confundir

    public DateServiceImpl(DateRepository dateRepository, Validator validator){
        this.dateRepository = dateRepository;
        this.validator = validator;
    }

    @Override
    public List<Date> getAll() {
        return dateRepository.findAll();
    }

    @Override
    public Date getById(Long dateId) {
        return dateRepository.findById(dateId).
                orElseThrow(()->new ResourceNotFoundException(ENTITY,dateId));
    }

    @Override
    public Page<Date> getAll(Pageable pageable) {
        return dateRepository.findAll(pageable);
    }

    @Override
    public Date create(Date dateapp) {


        return dateRepository.save(dateapp);

    }


}
