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
@Table(name="review")
public class Review extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="profilePhotoUrl")
    private String profilePhotoUrl;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerReview")
    private String customerReview;

    @Column(name = "customerScore")
    private int customerScore;

    @Column(name = "idPatient")
    private  int idPatient;

    @Column(name = "idDoctor")
    private int idDoctor;

}
