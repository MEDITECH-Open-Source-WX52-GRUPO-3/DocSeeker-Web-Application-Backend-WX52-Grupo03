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
@Table(name="patients")
public class Patient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cellphone", nullable = false)
    private Long cellphone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "photo", nullable = false)
    private String photo;

}
