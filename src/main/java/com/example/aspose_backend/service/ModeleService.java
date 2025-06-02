package com.example.aspose_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aspose_backend.model.Modele;
import com.example.aspose_backend.repository.ModeleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    public List<Modele> findAll() {
        return modeleRepository.findAll();
    }

    public Optional<Modele> findById(Integer id) {
        return modeleRepository.findById(id);
    }

    public Modele save(Modele modele) {
        return modeleRepository.save(modele);
    }

    public void deleteById(Integer id) {
        modeleRepository.deleteById(id);
    }
}