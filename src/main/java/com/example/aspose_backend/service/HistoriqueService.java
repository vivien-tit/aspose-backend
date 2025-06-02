package com.example.aspose_backend.service;

import com.example.aspose_backend.model.Historique;
import com.example.aspose_backend.repository.HistoriqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    public List<Historique> findAll() {
        return historiqueRepository.findAll();
    }

    public Optional<Historique> findById(Integer id) {
        return historiqueRepository.findById(id);
    }

    public List<Historique> findByDocumentId(Integer documentId) {
        return historiqueRepository.findByDocumentId(documentId);
    }

    public Historique save(Historique historique) {
        return historiqueRepository.save(historique);
    }

    public void deleteById(Integer id) {
        historiqueRepository.deleteById(id);
    }
}