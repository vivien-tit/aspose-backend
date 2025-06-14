package com.example.aspose_backend.service;

import com.example.aspose_backend.dto.HistoriqueDTO;
import com.example.aspose_backend.model.Document;
import com.example.aspose_backend.model.Historique;
import com.example.aspose_backend.repository.HistoriqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    public List<HistoriqueDTO> getAllHistorique() {
        return historiqueRepository.findAll().stream()
                .map(HistoriqueDTO::new)
                .collect(Collectors.toList());
    }

    public List<HistoriqueDTO> getHistoriqueByDocumentId(Long docId) {
        return historiqueRepository.findByDocumentId(docId).stream()
                .map(HistoriqueDTO::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void enregistrerHistorique(Document doc, String action) {
        Historique h = new Historique();

        // ✅ Utilise une instance "light" uniquement avec l’ID
        Document refDoc = new Document();
        refDoc.setId(doc.getId());

        h.setDocument(refDoc);
        h.setAction(action);
        h.setDateAction(LocalDateTime.now());
        historiqueRepository.save(h);
    }
}
