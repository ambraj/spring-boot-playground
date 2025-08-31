package com.pm.datajpamapping.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String gender;

    private LocalDate birthDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "patient")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();

}
