package com.meditech.healthapp.DockSeeker.healing.domain.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {

    Page<Patient> getAll (Pageable pageable);

    Patient getById(Long patientId);

    List<Patient> getAll();
    Patient create(Patient patient);

    Patient update(Long patientId, Patient request);

    ResponseEntity<?> delete(Long patientId);
}
