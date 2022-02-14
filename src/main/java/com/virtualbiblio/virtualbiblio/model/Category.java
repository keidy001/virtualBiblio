package com.virtualbiblio.virtualbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Livre> livre;
    @ManyToOne
    private Admin admin;
    private boolean delleted= false;

    public Category() {
    }



    public Category(String category, String description, List<Livre> livre, Admin admin,boolean delleted) {
        this.category = category;
        this.description = description;
        this.livre = livre;
        this.admin = admin;
        this.delleted = delleted;

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

    public boolean isDelleted() {
        return delleted;
    }

    public void setDelleted(boolean delleted) {
        this.delleted = delleted;
    }
}
