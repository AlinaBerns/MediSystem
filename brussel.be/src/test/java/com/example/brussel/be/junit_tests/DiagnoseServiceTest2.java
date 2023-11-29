package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Diagnose;
import com.example.brussel.be.model.Patient;
import com.example.brussel.be.service.DiagnoseService;
import com.example.brussel.be.service.PatientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiagnoseServiceTest2 {

    @Autowired
    private DiagnoseService diagnoseService;

    @Autowired
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    public void setUp(){
        patient = new Patient(2L,"testPat", "123");
        patientService.savePatient(patient);
    }

    @Test
    public void saveDiagnose(){
        Diagnose diagnose = new Diagnose(1L, "ICD10", "TEST", "TEST_DESCRIPTION", patient);
        diagnoseService.saveDiagnose(diagnose);
    }
}
