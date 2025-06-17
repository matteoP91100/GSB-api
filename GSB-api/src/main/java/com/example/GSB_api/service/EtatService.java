package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.Etat;
import com.example.GSB_api.repository.EtatRepository;

@Service
public class EtatService {
    @Autowired
    private EtatRepository etatRepository;

    public List<Etat> getAllEtats(){
        return etatRepository.findAll();
    }
    
    public Etat saveEtat (Etat etat) {
        return etatRepository.save(etat);
    }
}