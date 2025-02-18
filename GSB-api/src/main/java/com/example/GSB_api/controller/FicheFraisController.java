package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.FicheFrais;
import com.example.GSB_api.service.FicheFraisService;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/fichefrais")
public class FicheFraisController {
    @Autowired
    private FicheFraisService ficheFraisService;

    @GetMapping
    public List<FicheFrais> getAllFicheFrais() {
        return ficheFraisService.getAllFicheFrais();
    
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public FicheFrais createFicheFrais(@RequestBody FicheFrais ficheFrais) {
        return ficheFraisService.saveFicheFrais(ficheFrais);
    }
}