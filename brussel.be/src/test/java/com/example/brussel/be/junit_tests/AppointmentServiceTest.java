package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Appointment;
import com.example.brussel.be.model.Patient;
import com.example.brussel.be.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testGetAllAppointments(){
        List<Appointment> appointmentList = appointmentService.getAllAppointments();
        System.out.println(appointmentList);
        assertNotNull(appointmentList);
    }

    @Test
    public void testSaveAppointment(){
        LocalDate localDate = LocalDate.of(2023, 12, 1);

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(localDate);
        appointment.setAppointmentTime(LocalTime.of(14, 0));
        appointment.setAppointmentId(1L);

        appointmentService.createAppointment(appointment);

        Optional<Appointment> savedAppointment = appointmentService.getAppointmentById(1L);

        assertNotNull(savedAppointment);

    }

    @Test
    public void testDeleteAppointment(){
        appointmentService.deleteAppointment(1L);
        assertEquals(appointmentService.getAppointmentById(1L), Optional.empty());
    }
}
