package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_record_id")
    private Long medicalRecordId;

    @ManyToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;

    @Column(name = "record_date", nullable = false)
    private Date recordDate;

    @Column(name = "record_description", nullable = false)
    private String recordDescription;

// Constructors, getters, and setters

    public MedicalRecord(Long medicalRecordId, MedicalCard medicalCard, Date recordDate, String recordDescription) {
        this.medicalRecordId = medicalRecordId;
        this.medicalCard = medicalCard;
        this.recordDate = recordDate;
        this.recordDescription = recordDescription;
    }

    public MedicalRecord() {
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }
}