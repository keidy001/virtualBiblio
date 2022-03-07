package com.virtualbiblio.virtualbiblio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Documents implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocuments;
    private String titre;
    private String auteur;
    private String descriptoion;
    private Types types;
    private int note;
    private int recommendation;
    private String documents;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Admin admin;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "utilisateur_documents")
    private List<Utilisateur> utilisateurs;
    private boolean deleted = false;

    public Documents() {
    }

    public Documents( String titre, String auteur, String descriptoion, Types types, int note, int recommendation, String documents, Category category, Admin admin, List<Utilisateur> utilisateurs, boolean deleted) {
        this.titre = titre;
        this.auteur = auteur;
        this.descriptoion = descriptoion;
        this.types = types;
        this.note = note;
        this.recommendation = recommendation;
        this.documents = documents;
        this.category = category;
        this.admin = admin;
        this.utilisateurs = utilisateurs;
        this.deleted = deleted;
    }

    public Long getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(Long idDocuments) {
        this.idDocuments = idDocuments;
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

    public String getDescriptoion() {
        return descriptoion;
    }

    public void setDescriptoion(String descriptoion) {
        this.descriptoion = descriptoion;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
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

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
