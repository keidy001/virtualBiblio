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
    private String description;
    @Enumerated(EnumType.STRING)
    private Format format;
    private String domaine;
    private String livre;
    private double prix;
    private String photo;
    private String livre;
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

<<<<<<< HEAD
    public Livre(String titre, String auteur, String sommaire,String description, Format format, String domaine, double prix,String photo,String livre, Category category, Admin admin, List<Utilisateur> utilisateur, Librairy librairy, boolean delleted) {
=======
    public Livre(String titre, String auteur, String sommaire, Format format, String domaine, String livre, double prix,String photo, Category category, Admin admin, List<Utilisateur> utilisateur, Librairy librairy, boolean delleted) {
>>>>>>> 9979702d0fb5c08b3c0102dbb1cffa84587303cf
        this.titre = titre;
        this.auteur = auteur;
        this.sommaire = sommaire;
        this.description = description;
        this.format = format;
        this.domaine = domaine;
        this.livre = livre;
        this.prix = prix;
        this.category = category;
        this.admin = admin;
        this.utilisateur = utilisateur;
        this.librairy =librairy;
        this.delleted =delleted;
        this.photo =photo;
        this.livre = livre;
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

    public boolean isDelleted() {
        return delleted;
    }

    public void setDelleted(boolean delleted) {
        this.delleted = delleted;
    }

    public Librairy getLibrairy() {
        return librairy;
    }

    public void setLibrairy(Librairy librairy) {
        this.librairy = librairy;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLivre() {
        return livre;
    }

    public void setLivre(String livre) {
        this.livre = livre;
    }
<<<<<<< HEAD

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
=======
>>>>>>> 9979702d0fb5c08b3c0102dbb1cffa84587303cf
}
