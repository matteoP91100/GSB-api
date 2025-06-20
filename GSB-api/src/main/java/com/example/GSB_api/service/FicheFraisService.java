package com.example.GSB_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.FicheFrais;
import com.example.GSB_api.model.User;
import com.example.GSB_api.repository.FicheFraisRepository;

@Service

public class FicheFraisService {
    @Autowired
    private FicheFraisRepository FicheFraisRepository;

    public List<FicheFrais> getAllFicheFrais(){
        return FicheFraisRepository.findAll();
    }
    
    public FicheFrais saveFicheFrais (FicheFrais ficheFrais) {
        return FicheFraisRepository.save(ficheFrais);
    }
    
    public Optional<FicheFrais> getFicheFraisById(Long id) {
        return FicheFraisRepository.findById(id);
    }
    

    
    public List<FicheFrais> getFichesParMois(int mois) {
        return FicheFraisRepository.findFichesParMois(mois);
    }

    public List<FicheFrais> getFichesSelonRoleEtMois(User user, int mois) {
        if ("admin".equalsIgnoreCase(user.getRole())) {
            // Admin : toutes les fiches du mois
            return FicheFraisRepository.findFichesParMois(mois);
        } else {
            // Visiteur : uniquement ses fiches
            return FicheFraisRepository.findFichesByUserAndMois(user.getId(), mois);
        }
    }
    
}