package com.pm.datajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialty;

    @CreationTimestamp
    private LocalDate createdAt;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
}
