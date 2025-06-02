package com.example.aspose_backend.controller;

import com.example.aspose_backend.model.Personne;
import com.example.aspose_backend.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // autorise Angular
@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    @Autowired
    private PersonneRepository repository;

    @PostMapping
    public Personne ajouter(@RequestBody Personne p) {
        return repository.save(p);
    }

    @GetMapping
    public List<Personne> getAll() {
        return repository.findAll();
    }
}
