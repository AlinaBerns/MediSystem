package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Receptionist;
import com.example.brussel.be.repo.ReceptionistRepository;
import com.example.brussel.be.service.ReceptionistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReceptionistServiceTest {

    @Autowired
    private ReceptionistService receptionistService;

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Test
    public void testGetAllReceptionists() {
        List<Receptionist> receptionists = receptionistService.getAllReceptionists();
        assertEquals(0, receptionists.size()); // Предполагается, что в начале теста база данных пуста
    }

    @Test
    public void testSaveAndGetReceptionist() {
        Receptionist receptionist = new Receptionist();
        receptionist.setName("John");
        receptionist.setFamilyName("Doe");
        receptionist.setUsername("john.doe");
        receptionist.setPassword("password123");

        Receptionist savedReceptionist = receptionistService.saveReceptionist(receptionist);
        Long receptionistId = savedReceptionist.getId();

        Optional<Receptionist> retrievedReceptionist = receptionistService.getReceptionistById(receptionistId);
        assertTrue(retrievedReceptionist.isPresent());
        assertEquals("John", retrievedReceptionist.get().getName());
        assertEquals("Doe", retrievedReceptionist.get().getFamilyName());
        assertEquals("john.doe", retrievedReceptionist.get().getUsername());
        assertEquals("password123", retrievedReceptionist.get().getPassword());
    }

    @Test
    public void testDeleteReceptionist() {
        Receptionist receptionist = new Receptionist();
        receptionist.setName("Jane");
        receptionist.setFamilyName("Doe");
        receptionist.setUsername("jane.doe");
        receptionist.setPassword("password456");

        Receptionist savedReceptionist = receptionistService.saveReceptionist(receptionist);
        Long receptionistId = savedReceptionist.getId();

        receptionistService.deleteReceptionist(receptionistId);

        Optional<Receptionist> deletedReceptionist = receptionistService.getReceptionistById(receptionistId);
        assertTrue(deletedReceptionist.isEmpty());
    }
}