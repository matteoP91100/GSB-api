package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.FicheFrais;
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
}