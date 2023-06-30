package com.meditech.healthapp.DockSeeker.healing.resource;


import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResource {
    private Long id;
    private String profilePhotoUrl;
    private String customerName;
    private String customerReview;
    private int customerScore;
    private Long patientId;
    private Long doctorId;
}
