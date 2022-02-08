package com.virtualbiblio.virtualbiblio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    private String category;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Livre> livre;
    @ManyToOne
    private Admin admin;

    public Category() {
    }

    public Category(String category, String description, List<Livre> livre, Admin admin) {
        this.category = category;
        this.description = description;
        this.livre = livre;
        this.admin = admin;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
