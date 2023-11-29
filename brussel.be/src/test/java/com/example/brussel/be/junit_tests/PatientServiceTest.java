package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Patient;
import com.example.brussel.be.repo.PatientRepository;
import com.example.brussel.be.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetAllPatients() {
        Patient patient1 = new Patient(1L, "patient1", "12345");
        Patient patient2 = new Patient(2L, "patient2", "123456");

        patientRepository.save(patient1);
        patientRepository.save(patient2);

        List<Patient> patients = patientService.getAllPatients();

        assertNotNull(patients);
        assertEquals(2, patients.size());
    }

    @Test
    public void testGetPatientById() {
        Patient patient = new Patient(3L, "patient3", "1234567");
        patientRepository.save(patient);

        Optional<Patient> retrievedPatient = patientService.getPatientById(patient.getId());

        assertTrue(retrievedPatient.isPresent());
        assertEquals(patient.getId(), retrievedPatient.get().getId());
    }

    @Test
    public void testSavePatient() {

        Patient patient = new Patient(4L, "patient4", "12345678");

        Patient savedPatient = patientService.savePatient(patient);

        assertNotNull(savedPatient.getId());
    }

    @Test
    public void testDeletePatient() {

        Patient patient = new Patient(5L, "patient5", "123456789");
        patientRepository.save(patient);

        patientService.deletePatient(patient.getId());

        assertFalse(patientRepository.existsById(patient.getId()));
    }
}
