package com.example.GSB_api.controller;

    import java.util.List;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.LigneFraisForfait;
import com.example.GSB_api.service.LigneFraisForfaitService;
    
    @RestController
    @RequestMapping("/api/lignefraisforfait")
    @CrossOrigin(origins = "*")

    public class LigneFraisForfaitController {
        @Autowired
    private LigneFraisForfaitService ligneFraisForfaitService;

    @GetMapping("/all")
    public List<LigneFraisForfait> getAllFraisForfaits() {
        return ligneFraisForfaitService.getAllLigneFraisForfaits();
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
        // ➤ Ajouter plusieurs lignes de frais forfait et créer les frais forfaits SANS TESTER leur existence
        @PostMapping("/save")
    public LigneFraisForfait createLigneFraisForfait (@RequestBody LigneFraisForfait ligneFraisForfait) {
        return ligneFraisForfaitService.saveLigneFraisForfait(ligneFraisForfait);
    }
    }
