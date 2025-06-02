package com.example.aspose_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Modele> getAll() {
        return modeleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> getById(@PathVariable Integer id) {
        return modeleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Modele> create(@RequestBody Modele modele) {
        return ResponseEntity.ok(modeleService.save(modele));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modele> update(@PathVariable Integer id, @RequestBody Modele modele) {
        return modeleService.findById(id)
                .map(existing -> {
                    existing.setNom(modele.getNom());
                    existing.setCategorie(modele.getCategorie());
                    existing.setFichierTemplate(modele.getFichierTemplate());
                    existing.setApercuImg(modele.getApercuImg());
                    return ResponseEntity.ok(modeleService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (modeleService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        modeleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}