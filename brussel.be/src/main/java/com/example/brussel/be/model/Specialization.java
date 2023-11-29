package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "specializations")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Doctor> doctorList;

    public Specialization(Long id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public Specialization(Long id, String specialization, String description) {
        this.id = id;
        this.specialization = specialization;
        this.description = description;
    }

    public Specialization() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}