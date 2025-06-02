package com.example.aspose_backend.controller;

import com.example.aspose_backend.model.Historique;
import com.example.aspose_backend.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historiques")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriqueController {

    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping
    public List<Historique> getAll() {
        return historiqueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historique> getById(@PathVariable Integer id) {
        return historiqueService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/document/{documentId}")
    public List<Historique> getByDocument(@PathVariable Integer documentId) {
        return historiqueService.findByDocumentId(documentId);
    }

    @PostMapping
    public ResponseEntity<Historique> create(@RequestBody Historique historique) {
        return ResponseEntity.ok(historiqueService.save(historique));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (historiqueService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        historiqueService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
