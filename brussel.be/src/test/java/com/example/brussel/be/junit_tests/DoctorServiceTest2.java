package com.example.brussel.be.junit_tests;


import com.example.brussel.be.model.Doctor;
import com.example.brussel.be.service.DoctorService;
import com.example.brussel.be.service.MedicalCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DoctorServiceTest2 {

    @Autowired
    private DoctorService doctorService;

    @Test
    public void saveDoctor(){
        Doctor doctor = new Doctor(1L, "testsp", "123");
        doctorService.saveDoctor(doctor);

        Optional<Doctor> findDoctor = doctorService.getDoctorById(1L);

        assertEquals(doctor.getName(), findDoctor.get().getName());
    }
}
