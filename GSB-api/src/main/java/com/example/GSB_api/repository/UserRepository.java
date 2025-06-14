package com.example.GSB_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.GSB_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        SELECT u FROM User u
        WHERE u.id NOT IN (
            SELECT DISTINCT ff.ficheFrais.user.id FROM LigneFraisHorsForfait ff
        )
        """)
        List<User> findUsersWithoutFraisHorsForfait();

              @EntityGraph(attributePaths = {"fichesFrais"})
    List<User> findAll(); // Cette méthode chargera fichesFrais avec les visiteurs
    Optional<User> findByEmailAndPassword(String email, String password);
        
        }

