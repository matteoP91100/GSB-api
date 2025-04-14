package com.example.GSB_api.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FicheFrais {
   @Id
    private Long id;
    private int nbJustificatifs;
    private double montantValide;
    private LocalDate dateModif;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToMany(mappedBy ="ficheFrais",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<LigneFraisForfait> ligneFraisForfaits;


    @OneToMany(mappedBy ="ficheFrais",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FraisForfait> FraisForfaits;

    public List<FraisForfait> getFraisForfaits() {
        return FraisForfaits;
    }


    @OneToMany(mappedBy ="ficheFrais",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LigneFraisHorsForfait> ligneFraisHorsForfaits;




    @ManyToOne()
    
        @JoinColumn(name ="user_id", nullable = false)

    private User user;
    

    @ManyToOne()
        @JoinColumn(name ="etat_id", nullable = false)
    private Etat etat;



    public List<LigneFraisForfait> getLigneFraisForfaits() {
        return ligneFraisForfaits;
    }

    public void setLigneFraisForfaits(List<LigneFraisForfait> ligneFraisForfaits) {
        this.ligneFraisForfaits = ligneFraisForfaits;
    }


    public List<LigneFraisHorsForfait> getLigneFraisHorsForfaits() {
        return ligneFraisHorsForfaits;
    }

    public void setLigneFraisHorsForfaits(List<LigneFraisHorsForfait> ligneFraisHorsForfaits) {
        this.ligneFraisHorsForfaits = ligneFraisHorsForfaits;
    }
    
    public int getNbJustificatifs() {
        return nbJustificatifs;
    }

    public void setNbJustificatifs(int nbJustificatifs) {
        this.nbJustificatifs = nbJustificatifs;
    }

    public double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(double montantValide) {
        this.montantValide = montantValide;
    }

    public LocalDate getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}


