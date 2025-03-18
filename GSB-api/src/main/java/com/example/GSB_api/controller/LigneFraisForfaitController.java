package com.example.GSB_api.controller;

    import java.util.ArrayList;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

    import com.example.GSB_api.model.FicheFrais;
    import com.example.GSB_api.model.FraisForfait;
import com.example.GSB_api.model.LigneFraisForfait;
import com.example.GSB_api.repository.FicheFraisRepository;
import com.example.GSB_api.repository.FraisForfaitRepository;
import com.example.GSB_api.repository.LigneFraisForfaitRepository;
    
    @RestController
    @RequestMapping("/api/lignefraisforfait")
    public class LigneFraisForfaitController {
    
        @Autowired
        private LigneFraisForfaitRepository ligneFraisForfaitRepository;
    
        @Autowired
        private FicheFraisRepository ficheFraisRepository;
    
        @Autowired
        private FraisForfaitRepository fraisForfaitRepository;

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
        public ResponseEntity<List<LigneFraisForfait>> ajouterLignesFraisForfait(@RequestBody List<FraisForfait> fraisForfaitList) {
            List<LigneFraisForfait> lignesAjoutees = new ArrayList<>();
    
            // Créer une nouvelle fiche de frais systématiquement
            FicheFrais ficheFrais = new FicheFrais();
            ficheFrais = ficheFraisRepository.save(ficheFrais);
    
            // Nombre total de frais forfaits envoyés
            int quantiteTotal = fraisForfaitList.size();
    
            for (FraisForfait fraisForfaitData : fraisForfaitList) {
                // Créer un nouveau frais forfait
                FraisForfait fraisForfait = new FraisForfait();
                fraisForfait.setType(fraisForfaitData.getType());
                fraisForfait.setMontantF(fraisForfaitData.getMontantF());
                fraisForfait = fraisForfaitRepository.save(fraisForfait);
    
                // Créer une ligne de frais forfait
                LigneFraisForfait ligne = new LigneFraisForfait();
                ligne.setFicheFrais(ficheFrais);
                ligne.setFraisForfait(fraisForfait);
                ligne.setQuantite(quantiteTotal); // La quantité = nombre total de frais forfaits envoyés
    
                ligne = ligneFraisForfaitRepository.save(ligne);
                lignesAjoutees.add(ligne);
            }
    
            return ResponseEntity.ok(lignesAjoutees);
        }
    }
