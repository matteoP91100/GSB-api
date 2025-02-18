package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.LigneFraisForfait;
import com.example.GSB_api.service.LigneFraisForfaitService;

@RestController
@RequestMapping("/api/lignefraisforfaits")
public class LigneFraisForfaitController {
    @Autowired
    private LigneFraisForfaitService ligneFraisForfaitService;

    @GetMapping
    public List<LigneFraisForfait> getAllLigneFraisForfaits(){
        return ligneFraisForfaitService.getAllLigneFraisForfaits();
    }

    @PostMapping 
    public LigneFraisForfait createLigneFraisForfait (@RequestBody LigneFraisForfait ligneFraisForfait) {
        return ligneFraisForfaitService.saveLigneFraisForfait(ligneFraisForfait);
    }
}