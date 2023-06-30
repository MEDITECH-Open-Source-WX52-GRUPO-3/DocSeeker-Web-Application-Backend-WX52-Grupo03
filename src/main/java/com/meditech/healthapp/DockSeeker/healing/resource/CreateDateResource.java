package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateDateResource {

    @NotBlank
    @NotNull(message = "idPatient is required")
    private Long idPatient;

    @NotBlank
    @NotNull(message = "doctorId is required")
    private Long doctorId;

    @NotBlank
    @NotNull(message = "date is required")
    private String date;

    @NotBlank
    @NotNull(message = "hourId is required")
    private Long hourId;
}
