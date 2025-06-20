package com.example.GSB_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GSB_api.model.User;
import com.example.GSB_api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping 
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/visiteurs/sansfrais")
public List<User> getVisiteursSansFraisHorsForfait() {
    return userService.getVisiteursSansFraisHorsForfait();
}

    

}