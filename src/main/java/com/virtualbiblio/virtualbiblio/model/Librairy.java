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
    @OneToMany(mappedBy = "livre")
    private List<Livre> livre;
    @ManyToOne
    private Admin admin;


    public Librairy() {
    }

    public Librairy(String nom, String adresse, String telephone, String email, List<Livre> livre, Admin admin) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.livre = livre;
        this.admin = admin;
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
}
