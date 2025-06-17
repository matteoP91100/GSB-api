package com.example.GSB_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Etat {
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String libelle;

        @OneToMany(mappedBy ="etat", cascade = CascadeType.ALL)
    private List<FicheFrais> ficheFrais;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}