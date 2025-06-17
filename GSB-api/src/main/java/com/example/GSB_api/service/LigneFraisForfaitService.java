package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.LigneFraisForfait;
import com.example.GSB_api.repository.LigneFraisForfaitRepository;

@Service
public class LigneFraisForfaitService {

    @Autowired
    private LigneFraisForfaitRepository ligneFraisForfaitRepository;

    public List<LigneFraisForfait> getAllLigneFraisForfaits(){
        return ligneFraisForfaitRepository.findAll();
    }
    
    public LigneFraisForfait saveLigneFraisForfait(LigneFraisForfait ligneFraisForfait) {
        return ligneFraisForfaitRepository.save(ligneFraisForfait);
    }
    
}