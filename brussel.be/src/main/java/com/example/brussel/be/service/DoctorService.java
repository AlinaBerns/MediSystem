package com.example.brussel.be.service;

import com.example.brussel.be.model.Doctor;
import com.example.brussel.be.model.Specialization;
import com.example.brussel.be.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public void updateDoctorsSpecialization(Long id, Specialization specialization) {
        Optional<Doctor> optionalEntity = doctorRepository.findById(id);

        if (optionalEntity.isPresent()) {
            Doctor doctorToUpdate = optionalEntity.get();
            doctorToUpdate.setSpecialization(specialization);
            doctorRepository.save(doctorToUpdate);
        } else {
            System.out.println("Доктор не найден!!!");
        }
    }
}