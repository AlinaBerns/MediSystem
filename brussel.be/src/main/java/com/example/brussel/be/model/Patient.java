package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private MedicalCard medicalCard;

    @Column(name = "name")
    private String name;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "insurance")
    private String insurance;

    @Column(name = "address")
    private String address;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "contraindications", columnDefinition = "text")
    private String contraindications;

    @Column(name = "allergies", columnDefinition = "text")
    private String allergies;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "patient_id")
    private Long patientId;

    @OneToMany(mappedBy = "patient", targetEntity = Appointment.class)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<Diagnose> diagnoses;

    public Patient(Long id, String name, String familyName, String insurance, String address, String username, String password, String gender, String age, String contraindications, String allergies, String contactNumber, String email, Long patientId, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.insurance = insurance;
        this.address = address;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.contraindications = contraindications;
        this.allergies = allergies;
        this.contactNumber = contactNumber;
        this.email = email;
        this.patientId = patientId;
        this.appointments = appointments;
    }

    public Patient(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }



    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }
}