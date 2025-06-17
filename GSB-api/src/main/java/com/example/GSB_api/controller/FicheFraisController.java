package com.example.GSB_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.FicheFrais;
import com.example.GSB_api.model.User;
import com.example.GSB_api.repository.UserRepository;
import com.example.GSB_api.service.FicheFraisService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})

@RequestMapping("/api/fichefrais")
public class FicheFraisController {

    @Autowired
    private FicheFraisService ficheFraisService;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<FicheFrais> getAllFicheFrais() {
        return ficheFraisService.getAllFicheFrais();
    }

        @RequestMapping(value = "/save2", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }

    @PostMapping("/save2")
    public FicheFrais createFicheFrais(@RequestBody FicheFrais ficheFrais) {
        return ficheFraisService.saveFicheFrais(ficheFrais);
    }
    @GetMapping("/{id}")
public ResponseEntity<FicheFrais> getFicheFraisById(@PathVariable Long id) {
    Optional<FicheFrais> fiche = ficheFraisService.getFicheFraisById(id);
    if (fiche.isPresent()) {
        return ResponseEntity.ok(fiche.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}


@GetMapping("/mois/{mois}")
public ResponseEntity<List<FicheFrais>> getFichesMois(@PathVariable int mois) {
    List<FicheFrais> fiches = ficheFraisService.getFichesParMois(mois);
    return ResponseEntity.ok(fiches);
}

   @GetMapping("/fiches-de-frais")
    public ResponseEntity<?> getFichesDeFrais(@RequestParam int mois, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Non connecté");
        }

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur introuvable");
        }

        User user = userOpt.get();
        List<FicheFrais> fiches = ficheFraisService.getFichesSelonRoleEtMois(user, mois);

        return ResponseEntity.ok(fiches);
    }
}

