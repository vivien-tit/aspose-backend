package com.example.aspose_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aspose_backend.dto.ModeleDTO;
import com.example.aspose_backend.model.Modele;
import com.example.aspose_backend.repository.ModeleRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    public List<ModeleDTO> getAllModeles() {
        return modeleRepository.findAll().stream()
                .map(ModeleDTO::new)
                .collect(Collectors.toList());
    }

    public ModeleDTO getModeleById(Long id) {
        Modele modele = modeleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modèle non trouvé"));
        return new ModeleDTO(modele);
    }

    public ModeleDTO createModele(Modele modele) {
        return new ModeleDTO(modeleRepository.save(modele));
    }

    public ModeleDTO updateModele(Long id, Modele updated) {
        Modele modele = modeleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modèle non trouvé"));
        modele.setNom(updated.getNom());
        modele.setCategorie(updated.getCategorie());
        modele.setFichierTemplate(updated.getFichierTemplate());
        modele.setApercuImg(updated.getApercuImg());
        return new ModeleDTO(modeleRepository.save(modele));
    }

    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }
}
