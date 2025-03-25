package com.example.GSB_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FraisForfait {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double montantF;


    
    @ManyToOne
    @JoinColumn(name ="ficheFrais_id", nullable = false)
@JsonBackReference
private FicheFrais ficheFrais;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getMontantF() {
        return montantF;
    }
    public void setMontantF(double montant) {
        this.montantF = montant;
    }


}
