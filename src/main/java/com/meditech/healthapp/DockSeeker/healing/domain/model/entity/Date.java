package com.meditech.healthapp.DockSeeker.healing.domain.model.entity;

import com.meditech.healthapp.DockSeeker.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dates")
public class Date extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="idPatient", nullable = false)
    private Long idPatient;

    @Column(name="doctorId", nullable = false)
    private Long doctorId;

    @Column(name="date", nullable = false)
    private String date;

    @Column(name="hourId", nullable = false)
    private Long hourId;
}
