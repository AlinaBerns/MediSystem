package com.example.brussel.be.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @Column(name = "contact_number")
    private String contactNumber;

    public Doctor(Long id, String name, String familyName, String username, String password, Specialization specialization, String contactNumber) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.username = username;
        this.password = password;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    public Doctor(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Doctor(Long id, String name, String familyName, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.specialization = specialization;
    }

    public Doctor() {
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Objects.equals(getId(), doctor.getId()) && Objects.equals(getName(), doctor.getName()) && Objects.equals(getFamilyName(), doctor.getFamilyName()) && Objects.equals(getUsername(), doctor.getUsername()) && Objects.equals(getPassword(), doctor.getPassword()) && Objects.equals(getSpecialization(), doctor.getSpecialization()) && Objects.equals(getContactNumber(), doctor.getContactNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFamilyName(), getUsername(), getPassword(), getSpecialization(), getContactNumber());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", specialization=" + specialization +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}