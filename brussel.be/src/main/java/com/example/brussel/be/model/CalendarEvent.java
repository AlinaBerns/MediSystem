package com.example.brussel.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "events")
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime start;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime end;

    @Column(name = "patient_id") // добавлено поле для patient_id
    private Long patient_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "patient_id", insertable = false, updatable = false) // убрано поле patient, так как у нас есть patientId
    private Patient patient;

    @Column(name = "doctor_id")
    private Long doctorId;

    public CalendarEvent() {
        // конструктор по умолчанию
    }

    public CalendarEvent(String title, LocalDateTime start, LocalDateTime end, Long patientId, Long doctorId) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.patient_id = patientId;
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patient_id;
    }

    public void setPatientId(Long patientId) {
        this.patient_id = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalendarEvent that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStart(), that.getStart()) && Objects.equals(getEnd(), that.getEnd()) && Objects.equals(getPatient(), that.getPatient()) && Objects.equals(getDoctorId(), that.getDoctorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getStart(), getEnd(), getPatient(), getDoctorId());
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", patient=" + patient +
                ", doctorId=" + doctorId +
                '}';
    }
}
