package com.example.aspose_backend.service;

import com.example.aspose_backend.dto.DocumentDTO;
import com.example.aspose_backend.model.Document;
// Ensure the Document class exists at the specified package and is compiled
import com.example.aspose_backend.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private HistoriqueService historiqueService;

    public List<DocumentDTO> getAllDocuments() {
        return documentRepository.findAll()
            .stream()
            .map(DocumentDTO::new)
            .collect(Collectors.toList());
    }

    public DocumentDTO createDocument(Document document) {
        Document saved = documentRepository.save(document);
        historiqueService.enregistrerHistorique(saved, "Création");
        return new DocumentDTO(saved);
    }

    public DocumentDTO updateDocument(Long id, Document updatedDoc) {
        Document existing = documentRepository.findById(id).orElseThrow();
        existing.setTitre(updatedDoc.getTitre());
        existing.setType(updatedDoc.getType());
        existing.setContenuJson(updatedDoc.getContenuJson());
        existing.setModele(updatedDoc.getModele());
        existing.setUtilisateur(updatedDoc.getUtilisateur());
        Document saved = documentRepository.save(existing);
        historiqueService.enregistrerHistorique(saved, "Modification");
        return new DocumentDTO(saved);
    }

    @Transactional
    public void deleteDocument(Long id) {
        Document doc = documentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Document non trouvé avec l'ID : " + id));

        // 2. Supprimer ensuite le document
        documentRepository.delete(doc);
        
        // 1. Enregistrer l’historique
        historiqueService.enregistrerHistorique(doc, "Suppression");

        // 2. Supprimer ensuite le document
        // documentRepository.delete(doc);
    }

}
