package com.example.aspose_backend.dto;

import com.example.aspose_backend.model.Modele;
import com.example.aspose_backend.model.Modele.Categorie;

public class ModeleDTO {

    private Long id;
    private String nom;
    private Categorie categorie;
    private String fichierTemplate;
    private String apercuImg;

    public ModeleDTO(Modele modele) {
        this.id = modele.getId();
        this.nom = modele.getNom();
        this.categorie = modele.getCategorie();
        this.fichierTemplate = modele.getFichierTemplate();
        this.apercuImg = modele.getApercuImg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getFichierTemplate() {
        return fichierTemplate;
    }

    public void setFichierTemplate(String fichierTemplate) {
        this.fichierTemplate = fichierTemplate;
    }

    public String getApercuImg() {
        return apercuImg;
    }

    public void setApercuImg(String apercuImg) {
        this.apercuImg = apercuImg;
    }
}
