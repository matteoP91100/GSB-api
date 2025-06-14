package com.example.GSB_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.GSB_api.model.FicheFrais;


public interface FicheFraisRepository extends JpaRepository<FicheFrais, Long> {
    


@Query("SELECT f FROM FicheFrais f " +
       "JOIN f.user u " +
       "JOIN f.FraisForfaits ff " +
       "WHERE FUNCTION('MONTH', f.dateModif) = :mois " +
       "GROUP BY f.id ")
List<FicheFrais> findFichesParMois(@Param("mois") int mois);


}

