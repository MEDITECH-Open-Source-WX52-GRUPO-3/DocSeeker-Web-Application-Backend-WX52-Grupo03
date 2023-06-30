package com.meditech.healthapp.DockSeeker.healing.resource;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewResource {

    @NotBlank
    @NotNull(message = "hourId is required")
    private String profilePhotoUrl;

    @NotBlank
    @NotNull(message = "hourId is required")
    private String customerName;

    @NotBlank
    @NotNull(message = "hourId is required")
    private String customerReview;

    @NotBlank
    @NotNull(message = "hourId is required")
    private int customerScore;

    @NotBlank
    @NotNull(message = "hourId is required")
    private Long patientId;

    @NotBlank
    @NotNull(message = "hourId is required")
    private Long doctorId;
}
