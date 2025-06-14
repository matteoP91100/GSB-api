package com.example.GSB_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GSB_api.model.User;
import com.example.GSB_api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

public User saveUser( User user) {
        return userRepository.save(user);
    }

    
public List<User> getVisiteursSansFraisHorsForfait() {
    return userRepository.findUsersWithoutFraisHorsForfait();
}

}