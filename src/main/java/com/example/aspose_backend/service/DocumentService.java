package com.example.aspose_backend.service;

import com.example.aspose_backend.model.Document;
import com.example.aspose_backend.model.Historique;
import com.example.aspose_backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private HistoriqueService historiqueService;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Optional<Document> findById(Integer id) {
        return documentRepository.findById(id);
    }

    public List<Document> findByUtilisateurId(Integer utilisateurId) {
        return documentRepository.findByUtilisateurId(utilisateurId);
    }

    public List<Document> findByType(Document.Type type) {
        return documentRepository.findByType(type);
    }

    public Document save(Document document, Historique.Action action) {
        Document savedDocument = documentRepository.save(document);

        Historique historique = new Historique();
        historique.setAction(action);
        historique.setDocument(savedDocument);
        historique.setDateAction(java.time.LocalDateTime.now());

        historiqueService.save(historique);

        return savedDocument;
    }

    public void deleteById(Integer id) {
        Optional<Document> doc = documentRepository.findById(id);
        doc.ifPresent(d -> {
            documentRepository.deleteById(id);

            Historique historique = new Historique();
            historique.setAction(Historique.Action.Suppression);
            historique.setDocument(d);
            historique.setDateAction(java.time.LocalDateTime.now());

            historiqueService.save(historique);
        });
    }
}
