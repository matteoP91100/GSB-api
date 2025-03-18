package com.example.GSB_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.User;
import com.example.GSB_api.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/connexion")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.findUserByUsernameAndPassword(loginRequest.getName(), loginRequest.getPassword());
        
        if (user != null) {
            return ResponseEntity.ok(("Connexion réussie"));
        } else {
            return ResponseEntity.status(401).body("Nom d'utilisateur ou mot de passe incorrect");
        }
    }
}


