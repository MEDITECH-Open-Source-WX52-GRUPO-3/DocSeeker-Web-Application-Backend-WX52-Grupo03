package com.meditech.healthapp.DockSeeker.healing.domain.model.entity;

import com.meditech.healthapp.DockSeeker.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "area")
    private String area;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "patients")
    private Long patients;

    @Column(name = "years")
    private Long years;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "photo")
    private String photo;

    @ElementCollection
    @CollectionTable(name = "hours_available")
    private List<AvailableHours> hoursAvailable;

    @ElementCollection
    @CollectionTable(name = "education")
    private List<Education> education;
}

@Embeddable
@Getter
@Setter
@With
class AvailableHours {
    @Column(name = "hour_id")
    private Long id;

    @Column(name = "hours")
    private String hours;
}

@Embeddable
@Getter
@Setter
@With
class Education {
    @Column(name = "education_id")
    private Long id;

    @Column(name = "name")
    private String name;
}
