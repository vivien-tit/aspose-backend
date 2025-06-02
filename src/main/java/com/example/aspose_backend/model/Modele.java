package com.example.aspose_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modeles")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorie categorie;

    @Column(name = "fichier_template", nullable = false, length = 255)
    private String fichierTemplate;

    @Column(name = "apercu_img", length = 255)
    private String apercuImg;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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