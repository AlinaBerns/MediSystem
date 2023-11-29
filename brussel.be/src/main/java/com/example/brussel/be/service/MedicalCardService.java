package com.example.brussel.be.service;

import com.example.brussel.be.model.MedicalCard;
import com.example.brussel.be.repo.MedicalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCardService {

    @Autowired
    private MedicalCardRepository medicalCardRepository;

    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardRepository.findAll();
    }

    public Optional<MedicalCard> getMedicalCardById(Long id) {
        return medicalCardRepository.findById(id);
    }

    public MedicalCard saveMedicalCard(MedicalCard medicalCard) {
        return medicalCardRepository.save(medicalCard);
    }

    public void deleteMedicalCard(Long id) {
        medicalCardRepository.deleteById(id);
    }
}