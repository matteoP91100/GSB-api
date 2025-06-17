package com.example.GSB_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.GSB_api.model.LoginRequest;
import com.example.GSB_api.model.User;
import com.example.GSB_api.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // ajuste pour ton domaine Angular si nécessaire
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        Optional<User> userOpt = userRepository.findByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword());

        if (userOpt.isPresent()) {
            session.setAttribute("userId", userOpt.get().getId()); // stocke l'id de l'utilisateur connecté
            return ResponseEntity.ok(userOpt.get()); // ou retourne juste des infos nécessaires
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getLoggedUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Non connecté");
        }
        Optional<User> userOpt = userRepository.findById(userId);
        return userOpt.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
