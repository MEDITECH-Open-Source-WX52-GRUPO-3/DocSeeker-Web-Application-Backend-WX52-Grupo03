package com.meditech.healthapp.DockSeeker.healing.domain.model.entity;

import com.meditech.healthapp.DockSeeker.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="news")
public class New extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="image", nullable = false)
    private String image;

    @Column(name = "title", nullable = false, length = 1000)
    private String title;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "info", nullable = false)
    private String info;

    @Column(name = "views", nullable = false)
    private Integer views;
}
