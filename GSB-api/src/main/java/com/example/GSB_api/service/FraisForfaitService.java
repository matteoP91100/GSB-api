package com.example.GSB_api.service;

import java.util.List;
import java.util.Optional;

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

    public void saveMultipleFrais(List<FraisForfait> fraisList) {
        for (FraisForfait frais : fraisList) {
            fraisForfaRepository.save(frais);  // 🔄 Sauvegarde chaque frais un par un
        }
    }

    public boolean deletefraisForfaitById(Long id) {
        Optional<FraisForfait> fraisForfait = fraisForfaRepository.findById(id);
        
        if (fraisForfait.isPresent()) {
            fraisForfaRepository.deleteById(id);  // Suppression de l'entité
            return true;  // Retourne true si la suppression a été effectuée
        }
        
        return false;  // Retourne false si l'entité n'a pas été trouvée
    }
}