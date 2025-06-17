package com.example.GSB_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.FraisForfait;
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

        public boolean deletefraisHorsForfaitById(Long id) {
        Optional<LigneFraisHorsForfait> fraisHorsForfait = ligneFraisHorsForfaitRepository.findById(id);
        
        if (fraisHorsForfait.isPresent()) {
            ligneFraisHorsForfaitRepository.deleteById(id);  // Suppression de l'entité
            return true;  // Retourne true si la suppression a été effectuée
        }
        
        return false;  // Retourne false si l'entité n'a pas été trouvée
    }
}