package com.example.brussel.be.service;

import com.example.brussel.be.model.Receptionist;
import com.example.brussel.be.repo.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {

    private final ReceptionistRepository receptionistRepository;

    @Autowired
    public ReceptionistService(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    public List<Receptionist> getAllReceptionists() {
        return receptionistRepository.findAll();
    }

    public Optional<Receptionist> getReceptionistById(Long id) {
        return receptionistRepository.findById(id);
    }

    public Receptionist saveReceptionist(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public void deleteReceptionist(Long id) {
        receptionistRepository.deleteById(id);
    }
}