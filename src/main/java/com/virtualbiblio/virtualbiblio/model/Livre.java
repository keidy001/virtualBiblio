package com.virtualbiblio.virtualbiblio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;
    private String titre;
    private String auteur;
    private String sommaire;
    private Format format;
    private String domaine;
    private double prix;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Admin admin;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "utilisateur_Livres")
    private List<Utilisateur> utilisateur;
    @ManyToOne
    private Librairy librairy;
    private boolean delleted= false;

    public Livre() {
    }

    public Livre(String titre, String auteur, String sommaire, Format format, String domaine, double prix, Category category, Admin admin, List<Utilisateur> utilisateur) {
        this.titre = titre;
        this.auteur = auteur;
        this.sommaire = sommaire;
        this.format = format;
        this.domaine = domaine;
        this.prix = prix;
        this.category = category;
        this.admin = admin;
        this.utilisateur = utilisateur;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getSommaire() {
        return sommaire;
    }

    public void setSommaire(String sommaire) {
        this.sommaire = sommaire;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Utilisateur> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(List<Utilisateur> utilisateur) {
        this.utilisateur = utilisateur;
    }
}
