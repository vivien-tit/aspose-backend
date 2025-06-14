package com.example.aspose_backend.controller;

import com.example.aspose_backend.dto.DocumentDTO;
import com.example.aspose_backend.model.Document;
import com.example.aspose_backend.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<DocumentDTO> getAll() {
        return documentService.getAllDocuments();
    }

    @PostMapping
    public DocumentDTO create(@RequestBody Document doc) {
        return documentService.createDocument(doc);
    }

    @PutMapping("/{id}")
    public DocumentDTO update(@PathVariable Long id, @RequestBody Document doc) {
        return documentService.updateDocument(id, doc);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
    try {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Document supprimé avec succès");
    } catch (EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Document introuvable avec l'ID : " + id);
    } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Ce document est lié à d'autres entités et ne peut pas être supprimé.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erreur interne : " + e.getMessage());
    }
}

}

