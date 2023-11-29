package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.MedicalCard;
import com.example.brussel.be.model.MedicalRecord;
import com.example.brussel.be.model.Medication;
import com.example.brussel.be.model.Patient;
import com.example.brussel.be.service.MedicalCardService;
import com.example.brussel.be.service.MedicalRecordService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicalRecordServiceTest {

    @Autowired
    private MedicalCardService medicalCardService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    static private MedicalCard medicalCard;

    @BeforeAll
    static public void beforeAll(){

        medicalCard = new MedicalCard();

    }


    @Test
    public void testGetAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
        assertNotNull(medicalRecords);
    }

    @Test
    public void testSaveMedicalRecord() {

        @SuppressWarnings("deprecation")
        Date specificDate = new Date(121, Calendar.NOVEMBER, 28, 15, 30, 0);
        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setMedicalRecordId(1L);
        medicalRecord.setRecordDescription("test");
        medicalRecord.setRecordDate(specificDate);

        Optional<MedicalCard> medicalCard1 = medicalCardService.getMedicalCardById(2L);
        medicalRecord.setMedicalCard(medicalCard1.get());



        MedicalRecord savedMedicalRecord = medicalRecordService.saveMedicalRecord(medicalRecord);
        assertNotNull(savedMedicalRecord);
    }

    @Test
    public void deleteMedicalRecord() {
        medicalRecordService.deleteMedicalRecord(1L);
        assertEquals(medicalRecordService.getMedicalRecordById(1L), Optional.empty());
    }
}