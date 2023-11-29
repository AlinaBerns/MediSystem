package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Doctor;
import com.example.brussel.be.model.Specialization;
import com.example.brussel.be.service.DoctorService;
import com.example.brussel.be.service.SpecializationService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpecializationServiceTest {

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private DoctorService doctorService;

    @BeforeEach
    public void setUp(){

        Doctor doctor = new Doctor(1L, "Alina", "Berns", "ABerns", "123password", specializationService.getSpecializationById(1L).get(),"12345");
        doctorService.saveDoctor(doctor);
    }

    @Test
    public void saveSpecialization(){

        Specialization specialization = new Specialization(1L, "Cardiology", "Big Hurt");


        specializationService.saveSpecialization(specialization);

        Specialization findSpecialization = specializationService.getSpecializationById(1L).get();

        assertEquals(specialization.getId(), findSpecialization.getId());
    }

    @Test
    @Transactional
    public void specializationToDoctor(){
        Specialization specialization = new Specialization(2L, "Osteopat", "Ik heb een pijn in mijn rug");
        specializationService.saveSpecialization(specialization);

        Doctor doctor = doctorService.getDoctorById(2L).get();

        doctorService.saveDoctor(doctor);
        doctor.setSpecialization(specialization);
        assertEquals(specialization.getSpecialization(), doctor.getSpecialization().getSpecialization());
    }

    @Test
    public void specializationToDoctor_2(){
        Specialization specialization = specializationService.getSpecializationById(2L).get();

        Doctor doctor = doctorService.getDoctorById(2L).get();
        doctor.setName("Tom");
        doctorService.saveDoctor(doctor);

        doctorService.updateDoctorsSpecialization(doctor.getId(), specialization);
        assertEquals(specialization.getSpecialization(), doctor.getSpecialization().getSpecialization());
    }
}
