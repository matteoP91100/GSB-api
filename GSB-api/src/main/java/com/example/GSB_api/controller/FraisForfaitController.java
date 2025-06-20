package com.example.GSB_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.FicheFrais;
import com.example.GSB_api.model.FraisForfait;
import com.example.GSB_api.service.FraisForfaitService;

@RestController
@RequestMapping("/api/fraisforfaits")
@CrossOrigin(origins = "*")
public class FraisForfaitController {
    @Autowired
    private FraisForfaitService fraisForfaitService;

    @GetMapping("/all")
    public List<FraisForfait> getAllFraisForfaits() {
        return fraisForfaitService.getAllFraisForfaits();
    }

    @RequestMapping(value = "/save", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }

    @PostMapping("/save")
    public String addMultipleFrais(@RequestBody List<FraisForfait> fraisList) {
        for (FraisForfait frais : fraisList) {
            fraisForfaitService.saveMultipleFrais(fraisList);
        }
        return "Tous les frais forfaitaires ont été ajoutés avec succès !";
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFraisForfaitById(@PathVariable Long id) {
            boolean isDeleted = fraisForfaitService.deletefraisForfaitById(id);  // Suppression via le service
            if (isDeleted) {
                return ResponseEntity.noContent().build();  // Réponse 204 No Content si la suppression est réussie
            } else {
                return ResponseEntity.notFound().build();  // Réponse 404 Not Found si l'élément n'existe pas
            }
}
}
