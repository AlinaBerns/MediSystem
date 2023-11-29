package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.MedicalCard;
import com.example.brussel.be.service.MedicalCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicalCardServiceTest {

    @Autowired
    private MedicalCardService medicalCardService;

    @Test
    public void testGetAllMedicalCards() {
        List<MedicalCard> medicalCards = medicalCardService.getAllMedicalCards();
        System.out.println(medicalCards);
        assertNotNull(medicalCards);
    }

    @Test
    public void testSaveMedicalCard() {
        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setMedicalCardId(1L);
        medicalCard.setMedicalNumber("3214567389");
        MedicalCard savedMedicalCard = medicalCardService.saveMedicalCard(medicalCard);
        assertNotNull(savedMedicalCard);
    }

    @Test
    public void testDeleteMedicalCard() {
        medicalCardService.deleteMedicalCard(1L);
        Optional<MedicalCard> medicalCard = medicalCardService.getMedicalCardById(1L);
        assertEquals(Optional.empty(), medicalCard);
    }
}