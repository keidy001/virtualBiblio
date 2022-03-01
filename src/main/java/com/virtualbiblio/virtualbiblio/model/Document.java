package com.virtualbiblio.virtualbiblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocument;
    private String title;
    private TypeDocument typeDocument;
    private String content;
    private String description;

}
