package com.example.brussel.be.mockito_tests;

import com.example.brussel.be.model.Doctor;
import com.example.brussel.be.model.Specialization;
import com.example.brussel.be.repo.DoctorRepository;
import com.example.brussel.be.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    public void testGetAllDoctors() {
        // Arrange
        Doctor doctor1 = new Doctor(1L, "John", "Doe", "john_doe", "password", new Specialization(1L, "Dermatology"), "123456789");
        Doctor doctor2 = new Doctor(2L, "Jane", "Smith", "jane_smith", "password", new Specialization(1L, "Dermatology"), "987654321");
        List<Doctor> doctors = Arrays.asList(doctor1, doctor2);
        when(doctorRepository.findAll()).thenReturn(doctors);

        // Act
        List<Doctor> result = doctorService.getAllDoctors();

        System.out.println(result);

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDoctorById() {
        // Arrange
        Doctor doctor = new Doctor(1L, "John", "Doe", "john_doe", "password", new Specialization(1L, "test1"), "123456789");
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        // Act
        Optional<Doctor> result = doctorService.getDoctorById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
    }

    @Test
    public void testSaveDoctor() {
        // Arrange
        Doctor doctor = new Doctor(1L, "John", "Doe", "john_doe", "password", new Specialization(1L, "test"), "123456789");
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        // Act
        Doctor result = doctorService.saveDoctor(doctor);

        // Assert
        assertEquals("john_doe", result.getUsername());
    }


    @Test
    public void testDeleteDoctor() {
        // Arrange
        Long doctorId = 1L;

        // Act
        doctorService.deleteDoctor(doctorId);

        // Assert
        verify(doctorRepository, times(1)).deleteById(doctorId);
    }
}