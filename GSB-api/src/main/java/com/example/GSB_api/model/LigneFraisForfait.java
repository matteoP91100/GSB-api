package com.example.GSB_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneFraisForfait {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int quantite;

    @ManyToOne
        @JoinColumn(name ="ficheFrais_id", nullable = false)
    private FicheFrais ficheFrais;
    
    @ManyToOne
        @JoinColumn(name ="fraisForfait_id", nullable = false)
    private FraisForfait fraisForfait;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
