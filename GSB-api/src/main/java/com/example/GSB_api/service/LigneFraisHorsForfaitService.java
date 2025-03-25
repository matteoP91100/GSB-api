package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.LigneFraisHorsForfait;
import com.example.GSB_api.repository.LigneFraisHorsForfaitRepository;

@Service
public class LigneFraisHorsForfaitService {
    @Autowired
    private LigneFraisHorsForfaitRepository ligneFraisHorsForfaitRepository;

    public List<LigneFraisHorsForfait> getAllLigneFraisHorsForfaits() {
        return ligneFraisHorsForfaitRepository.findAll();
    }

    public LigneFraisHorsForfait saveLigneFraisHorsForfait( LigneFraisHorsForfait ligneFraisHorsForfait) {
        return ligneFraisHorsForfaitRepository.save(ligneFraisHorsForfait);
    }
}