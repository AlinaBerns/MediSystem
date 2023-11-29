package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "diagnosis")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    private Long diagnosisId;

    @Column(name = "icd", nullable = false)
    private String icd;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Diagnose(Long diagnosisId, String icd, String name, String description, Patient patient) {
        this.diagnosisId = diagnosisId;
        this.icd = icd;
        this.name = name;
        this.description = description;
        this.patient = patient;
    }

    public Diagnose() {

    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnose diagnose)) return false;
        return Objects.equals(getDiagnosisId(), diagnose.getDiagnosisId()) && Objects.equals(getIcd(), diagnose.getIcd()) && Objects.equals(getName(), diagnose.getName()) && Objects.equals(getDescription(), diagnose.getDescription()) && Objects.equals(getPatient(), diagnose.getPatient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiagnosisId(), getIcd(), getName(), getDescription(), getPatient());
    }

    @Override
    public String toString() {
        return "Diagnose{" +
                "diagnosisId=" + diagnosisId +
                ", icd='" + icd + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", patient=" + patient +
                '}';
    }
}
