package com.example.aspose_backend.model;

import jakarta.persistence.*;
@Entity
@Table(name = "modeles")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Categorie categorie;

    @Column(name = "fichier_template")
    private String fichierTemplate;

    @Column(name = "apercu_img")
    private String apercuImg;


    // Getters et Setters

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

    public enum Categorie {
        Professionnel,
        Personnel
    }
}