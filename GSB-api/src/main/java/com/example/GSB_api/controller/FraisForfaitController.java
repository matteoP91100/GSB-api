package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.FraisForfait;
import com.example.GSB_api.service.FraisForfaitService;

@RestController
@RequestMapping("/api/fraisforfaits")
public class FraisForfaitController {
    @Autowired
    private FraisForfaitService fraisForfaitService;

    @GetMapping
    public List<FraisForfait> getAllFraisForfaits() {
        return fraisForfaitService.getAllFraisForfaits();
    }

    @PostMapping
    public FraisForfait createFraisForfait(@RequestBody FraisForfait fraisForfait){
        return fraisForfaitService.saveFraisForfait(fraisForfait);
    }
}