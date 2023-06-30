package com.meditech.healthapp.DockSeeker.healing.domain.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {

    Page<Doctor> getAll(Pageable pageable);

    Doctor getById(Long doctorId);

    List<Doctor> getAll();
    Doctor create(Doctor doctor);

    Doctor update(Long doctorId, Doctor request);

    ResponseEntity<?> delete(Long doctorId);
}
