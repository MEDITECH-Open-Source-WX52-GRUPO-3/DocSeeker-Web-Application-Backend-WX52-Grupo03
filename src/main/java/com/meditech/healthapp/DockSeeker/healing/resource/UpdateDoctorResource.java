package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDoctorResource {
    @NotBlank
    @NotNull(message = "dni is required")
    private String dni;

    @NotBlank
    @NotNull(message = "name is required")
    private String name;

    @NotBlank
    @NotNull(message = "password is required")
    private String password;

    @NotBlank
    @NotNull(message = "area is required")
    private String area;

    @NotBlank
    @NotNull(message = "genre is required")
    private String genre;

    private String description;

    @NotBlank
    @NotNull(message = "patients is required")
    private Long patients;

    @NotBlank
    @NotNull(message = "years is required")
    private Long years;

    @NotBlank
    @NotNull(message = "cost is required")
    private Long cost;

    @NotBlank
    @NotNull(message = "photo is required")
    private String photo;

    @NotBlank
    @NotNull(message = "age is required")
    private Long age;

    private List<UpdateAvailableHoursResource> hoursAvailable;
    private List<UpdateEducationResource> education;
}
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
class UpdateAvailableHoursResource {
    @NotBlank
    private String hours;
}

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
class UpdateEducationResource {
    @NotBlank
    private String name;
}