package com.example.aspose_backend.controller;

import com.example.aspose_backend.model.Document;
import com.example.aspose_backend.model.Historique;
import com.example.aspose_backend.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAll() {
        return documentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable Integer id) {
        return documentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Document> getByUtilisateur(@PathVariable Integer utilisateurId) {
        return documentService.findByUtilisateurId(utilisateurId);
    }

    @GetMapping("/type/{type}")
    public List<Document> getByType(@PathVariable Document.Type type) {
        return documentService.findByType(type);
    }

    @PostMapping
    public ResponseEntity<Document> create(@RequestBody Document document) {
        Document createdDoc = documentService.save(document, Historique.Action.Création);
        return ResponseEntity.ok(createdDoc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> update(@PathVariable Integer id, @RequestBody Document updatedDoc) {
        return documentService.findById(id)
                .map(existingDoc -> {
                    updatedDoc.setId(existingDoc.getId()); // Pour garder le même ID
                    Document updated = documentService.save(updatedDoc, Historique.Action.Modification);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (documentService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        documentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
