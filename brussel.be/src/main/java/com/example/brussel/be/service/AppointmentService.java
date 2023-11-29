package com.example.brussel.be.service;

import com.example.brussel.be.model.Appointment;
import com.example.brussel.be.repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepo appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepo appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Additional methods for business logic related to appointments

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void createAppointment(Appointment appointment) {
        // Additional logic before saving to the database, if needed
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Appointment appointment) {
        // Additional logic before updating in the database, if needed
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
