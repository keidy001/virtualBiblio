package com.virtualbiblio.virtualbiblio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Librairy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibrairy;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String photo;
    @OneToMany(mappedBy = "librairy")
    private List<Livre> livre;
    @ManyToOne
    private Admin admin;
    private boolean deleted= false;

    public Librairy() {
    }

    public Librairy(String nom, String adresse, String telephone, String email, String photo, List<Livre> livre, Admin admin, boolean deleted) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.photo = photo;
        this.livre = livre;
        this.admin = admin;
        this.deleted = deleted;
    }

    public Long getIdLibrairy() {
        return idLibrairy;
    }

    public void setIdLibrairy(Long idLibrairy) {
        this.idLibrairy = idLibrairy;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Livre> getLivre() {
        return livre;
    }

    public void setLivre(List<Livre> livre) {
        this.livre = livre;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
