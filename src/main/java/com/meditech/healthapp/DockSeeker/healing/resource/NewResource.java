package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Service;

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
