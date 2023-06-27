package com.meditech.healthapp.DockSeeker.healing.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNewResource {
    private Long id;

    @NotNull(message = "image is required")
    private String image;

    @NotBlank
    @NotNull(message = "title is required")
    @Size(max = 100)
    private String title;
    private String description;
    private String info;
    private Integer views;
}
