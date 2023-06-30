package com.meditech.healthapp.DockSeeker.healing.domain.presistence;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByDni(String dni);
}
