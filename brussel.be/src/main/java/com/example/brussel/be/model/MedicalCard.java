package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "medical_card")
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_card_id")
    private Long medicalCardId;

    @OneToMany(mappedBy = "medicalCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords = new ArrayList<>();


    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    @Column(name = "medical_number", nullable = false)
    private String medicalNumber;

    public MedicalCard(Long medicalCardId, String medicalNumber) {
        this.medicalCardId = medicalCardId;
        this.medicalNumber = medicalNumber;
    }

    public MedicalCard(Long medicalCardId, Patient patient, String medicalNumber) {
        this.medicalCardId = medicalCardId;
        this.patient = patient;
        this.medicalNumber = medicalNumber;
    }

    public MedicalCard() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(Long medicalCardId) {
        this.medicalCardId = medicalCardId;
    }

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber;
    }

    @Override
    public String toString() {
        return "MedicalCard{" +
                "medicalCardId=" + medicalCardId +
                ", medicalNumber='" + medicalNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalCard that)) return false;
        return Objects.equals(getMedicalCardId(), that.getMedicalCardId()) && Objects.equals(getMedicalNumber(), that.getMedicalNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedicalCardId(), getMedicalNumber());
    }
}