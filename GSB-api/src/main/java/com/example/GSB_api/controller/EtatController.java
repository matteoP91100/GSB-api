package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.Etat;
import com.example.GSB_api.service.EtatService;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/etats")
public class EtatController {

    @Autowired
    private EtatService etatService;

    @GetMapping
    public List <Etat> getAllEtats(){
        return etatService.getAllEtats();
    }
    
    @PostMapping
    public Etat createEtat(@RequestBody Etat etat) {
        return etatService.saveEtat(etat);
    }
}