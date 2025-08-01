package com.example.aspose_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String type;

    @Column(name = "contenu_json", columnDefinition = "json")
    private String contenuJson;

    @Column(name = "date_creation", updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Column(name = "derniere_modif")
    private LocalDateTime derniereModif;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Modele modele;

    @PreUpdate
    public void preUpdate() {
        this.derniereModif = LocalDateTime.now();
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}
