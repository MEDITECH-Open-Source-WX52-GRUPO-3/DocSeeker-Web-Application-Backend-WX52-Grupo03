package com.meditech.healthapp.DockSeeker.healing.domain.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Date;
import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DateService {

    Page<Date> getAll(Pageable pageable);

    Date getById(Long dateId);

    List<Date> getAll();
    Date create(Date dateapp);

}
