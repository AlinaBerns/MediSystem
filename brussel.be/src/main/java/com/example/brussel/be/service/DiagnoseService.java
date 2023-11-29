package com.example.brussel.be.service;

import com.example.brussel.be.model.Diagnose;
import com.example.brussel.be.repository.DiagnoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnoseService {

    private final DiagnoseRepository diagnoseRepository;

    @Autowired
    public DiagnoseService(DiagnoseRepository diagnoseRepository) {
        this.diagnoseRepository = diagnoseRepository;
    }

    public List<Diagnose> getAllDiagnoses() {
        return diagnoseRepository.findAll();
    }

    public Optional<Diagnose> getDiagnoseById(Long id) {
        return diagnoseRepository.findById(id);
    }

    public Diagnose saveDiagnose(Diagnose diagnose) {
        return diagnoseRepository.save(diagnose);
    }

    public void deleteDiagnose(Long id) {
        diagnoseRepository.deleteById(id);
    }
}