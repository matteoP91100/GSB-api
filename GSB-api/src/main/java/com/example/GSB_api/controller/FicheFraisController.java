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

import com.example.GSB_api.model.FicheFrais;
import com.example.GSB_api.service.FicheFraisService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})

@RequestMapping("/api/fichefrais")
public class FicheFraisController {

    @Autowired
    private FicheFraisService ficheFraisService;

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
}
