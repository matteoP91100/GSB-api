package com.example.GSB_api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FicheFrais {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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


    @OneToMany(mappedBy ="ficheFrais", cascade = CascadeType.ALL)
    private List<LigneFraisForfait> ligneFraisForfaits;

    @OneToMany(mappedBy ="ficheFrais", cascade = CascadeType.ALL)
    private List<LigneFraisHorsForfait> ligneFraisHorsForfaits;

    @ManyToOne(fetch =FetchType.EAGER)
        @JoinColumn(name ="user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch =FetchType.EAGER)
        @JoinColumn(name ="etat_id", nullable = false)
    private Etat etat;

}


