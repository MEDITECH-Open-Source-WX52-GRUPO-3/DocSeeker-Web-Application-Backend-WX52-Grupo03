package com.meditech.healthapp.DockSeeker.healing.resource;

import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResource {

    private Long id;
    private String dni;
    private String password;
    private String area;
    private String genre;
    private String description;
    private Long patients;
    private Long years;
    private Long cost;

    private Long age;
    private String photo;
    private List<AvailableHoursResource> hoursAvailable;
    private List<EducationResource> education;
}

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
class AvailableHoursResource {
    private String hours;
}

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
class EducationResource {
    private String name;
}