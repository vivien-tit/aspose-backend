package com.example.aspose_backend.dto;

import java.time.LocalDateTime;

import com.example.aspose_backend.model.Historique;

public class HistoriqueDTO {

    private Long id;
    private String action;
    private LocalDateTime dateAction;
    private Long documentId;
    private String titreDocument;

    public HistoriqueDTO(Historique historique) {
        this.id = historique.getId();
        this.action = historique.getAction();
        this.dateAction = historique.getDateAction();
        this.documentId = historique.getDocument().getId();
        this.titreDocument = historique.getDocument().getTitre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDateTime dateAction) {
        this.dateAction = dateAction;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getTitreDocument() {
        return titreDocument;
    }

    public void setTitreDocument(String titreDocument) {
        this.titreDocument = titreDocument;
    }
}

