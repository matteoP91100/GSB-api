package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.FraisForfait;
import com.example.GSB_api.repository.FraisForfaitRepository;

@Service
public class FraisForfaitService {
    @Autowired
    private FraisForfaitRepository fraisForfaRepository;

    public List<FraisForfait> getAllFraisForfaits() {
        return fraisForfaRepository.findAll();
    }

    public FraisForfait saveFraisForfait(FraisForfait fraisForfait){
        return fraisForfaRepository.save(fraisForfait);
    }
}