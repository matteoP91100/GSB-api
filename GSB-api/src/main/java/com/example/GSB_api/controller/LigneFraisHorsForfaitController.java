package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.LigneFraisHorsForfait;
import com.example.GSB_api.service.LigneFraisHorsForfaitService;

@RestController
@RequestMapping("/api/lignefraishorsforfaits")
public class LigneFraisHorsForfaitController {
    @Autowired
    private LigneFraisHorsForfaitService ligneFraisHorsForfaitService;

    @GetMapping
    public List<LigneFraisHorsForfait> getAllLigneFraisHorsForfaits(){
        return ligneFraisHorsForfaitService.getAllLigneFraisHorsForfaits();
    }

    @PostMapping("/save")
    public LigneFraisHorsForfait creatLigneFraisHorsForfait (@RequestBody LigneFraisHorsForfait ligneFraisHorsForfait) {
        return ligneFraisHorsForfaitService.savLigneFraisHorsForfait(ligneFraisHorsForfait);
    }
    
}