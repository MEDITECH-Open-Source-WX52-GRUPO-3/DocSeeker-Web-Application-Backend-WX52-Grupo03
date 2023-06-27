package com.meditech.healthapp.DockSeeker.healing.resource;

import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class NewResource {

    private Long id;
    private String image;
    private String title;
    private String description;
    private String info;
    private Integer views;
}
