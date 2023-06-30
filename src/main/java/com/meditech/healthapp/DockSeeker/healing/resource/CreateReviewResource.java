package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewResource {

    private String profilePhotoUrl;
    private String customerName;
    private String customerReview;
    private int customerScore;
    private  int idPatient;
    private int idDoctor;
}
