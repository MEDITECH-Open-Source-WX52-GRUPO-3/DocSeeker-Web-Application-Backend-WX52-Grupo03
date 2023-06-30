package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {

    @NotBlank
    @NotNull(message = "name is required")
    private String name;

    @NotBlank
    @NotNull(message = "dni is required")
    private String dni;

    @NotBlank
    @NotNull(message = "genre is required")
    private String genre;

    @NotBlank
    @NotNull(message = "birthday is required")
    private String birthday;

    @NotBlank
    @NotNull(message = "email is required")
    private String email;

    @NotBlank
    @NotNull(message = "cellphone is required")
    private Long cellphone;

    @NotBlank
    @NotNull(message = "password is required")
    private String password;

    @NotNull(message = "image is required")
    private String photo;
}
