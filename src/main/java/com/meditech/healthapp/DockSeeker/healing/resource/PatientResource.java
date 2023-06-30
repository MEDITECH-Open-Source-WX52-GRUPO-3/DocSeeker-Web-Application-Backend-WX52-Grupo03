package com.meditech.healthapp.DockSeeker.healing.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PatientResource {

    private Long id;
    private String name;
    private String dni;
    private String genre;
    private String birthday;
    private String email;
    private Long cellphone;
    private String password;
    private String photo;
}
