package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.validation.constraints.NotNull;

public class UpdateReviewResource {

    private Long id;
    private String profilePhotoUrl;

    @NotNull(message = "title is required")
    private String customerName;
    private String customerReview;
    private int customerScore;
    private Long patientId;
    private Long doctorId;
}
