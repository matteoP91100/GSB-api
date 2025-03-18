package com.example.GSB_api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FraisForfait {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double montantF;

    @OneToMany(mappedBy ="fraisForfait", cascade = CascadeType.ALL)
    private List<LigneFraisForfait> ligneFraisForfaits = new ArrayList<>();

    public List<LigneFraisForfait> getLigneFraisForfaits() {
        return ligneFraisForfaits;
    }
    public void setLigneFraisForfaits(List<LigneFraisForfait> ligneFraisForfaits) {
        this.ligneFraisForfaits = ligneFraisForfaits;
    }
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
