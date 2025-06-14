package com.example.aspose_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.aspose_backend.dto.ModeleDTO;
import com.example.aspose_backend.model.Modele;
import com.example.aspose_backend.service.ModeleService;

import java.util.List;

@RestController
@RequestMapping("/api/modeles")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeleController {

    @Autowired
    private ModeleService modeleService;

    @GetMapping
    public List<ModeleDTO> getAll() {
        return modeleService.getAllModeles();
    }

    @GetMapping("/{id}")
    public ModeleDTO getById(@PathVariable Long id) {
        return modeleService.getModeleById(id);
    }

    @PostMapping
    public ModeleDTO create(@RequestBody Modele modele) {
        return modeleService.createModele(modele);
    }

    @PutMapping("/{id}")
    public ModeleDTO update(@PathVariable Long id, @RequestBody Modele modele) {
        return modeleService.updateModele(id, modele);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        modeleService.deleteModele(id);
        return ResponseEntity.ok().build();
    }
}