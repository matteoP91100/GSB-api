package com.example.GSB_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GSB_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
       @EntityGraph(attributePaths = {"fichesFrais"})
    List<User> findAll(); // Cette méthode chargera fichesFrais avec les visiteurs
}

