package com.example.GSB_api.controller;

import java.util.List;

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

import com.example.GSB_api.model.LigneFraisHorsForfait;
import com.example.GSB_api.service.LigneFraisHorsForfaitService;

@RestController
@RequestMapping("/api/lignefraishorsforfaits")
@CrossOrigin(origins = "*")

public class LigneFraisHorsForfaitController {
    @Autowired
    private LigneFraisHorsForfaitService ligneFraisHorsForfaitService;

    @GetMapping("/all")
    public List<LigneFraisHorsForfait> getAllLigneFraisHorsForfaits(){
        return ligneFraisHorsForfaitService.getAllLigneFraisHorsForfaits();
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
    public LigneFraisHorsForfait createLigneFraisHorsForfait (@RequestBody LigneFraisHorsForfait ligneFraisHorsForfait) {
        return ligneFraisHorsForfaitService.saveLigneFraisHorsForfait(ligneFraisHorsForfait);
    }
            @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFraisHorsForfaitById(@PathVariable Long id) {
            boolean isDeleted = ligneFraisHorsForfaitService.deletefraisHorsForfaitById(id);  // Suppression via le service
            if (isDeleted) {
                return ResponseEntity.noContent().build();  // Réponse 204 No Content si la suppression est réussie
            } else {
                return ResponseEntity.notFound().build();  // Réponse 404 Not Found si l'élément n'existe pas
            }
}
}