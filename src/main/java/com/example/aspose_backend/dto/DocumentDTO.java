package com.example.aspose_backend.dto;

import java.time.LocalDateTime;

import com.example.aspose_backend.model.Document;

public class DocumentDTO {
    private Long id;
    private String titre;
    private String type;
    private String contenuJson;
    private LocalDateTime dateCreation;
    private LocalDateTime derniereModif;
    private Integer utilisateurId;
    private Long modeleId;

    public DocumentDTO(Document document) {
        this.id = document.getId();
        this.titre = document.getTitre();
        this.type = document.getType();
        this.contenuJson = document.getContenuJson();
        this.dateCreation = document.getDateCreation();
        this.derniereModif = document.getDerniereModif();
        this.utilisateurId = document.getUtilisateur().getId();
        this.modeleId = document.getModele() != null ? document.getModele().getId() : null;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenuJson() {
        return contenuJson;
    }

    public void setContenuJson(String contenuJson) {
        this.contenuJson = contenuJson;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDerniereModif() {
        return derniereModif;
    }

    public void setDerniereModif(LocalDateTime derniereModif) {
        this.derniereModif = derniereModif;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getModeleId() {
        return modeleId;
    }

    public void setModeleId(Long modeleId) {
        this.modeleId = modeleId;
    }
    // (Tu peux générer automatiquement dans ton IDE)
}
