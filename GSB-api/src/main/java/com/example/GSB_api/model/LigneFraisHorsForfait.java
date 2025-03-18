package com.example.GSB_api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class LigneFraisHorsForfait {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double montantHF;
    private String libelle;
    
    @ManyToOne
        @JoinColumn(name ="ficheFrais_id", nullable = false)
    private FicheFrais ficheFrais;
    
    public FicheFrais getFicheFrais() {
        return ficheFrais;
    }
    public void setFicheFrais(FicheFrais ficheFrais) {
        this.ficheFrais = ficheFrais;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontantHF() {
        return montantHF;
    }
    public void setMontantHF(double montant) {
        this.montantHF = montant;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
