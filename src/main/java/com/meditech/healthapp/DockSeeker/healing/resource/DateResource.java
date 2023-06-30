package com.meditech.healthapp.DockSeeker.healing.resource;

import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DateResource {

    private Long id;
    private Long idPatient;
    private Long doctorId;
    private String date;
    private Long hourId;

}
