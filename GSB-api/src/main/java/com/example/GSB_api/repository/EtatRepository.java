package com.example.GSB_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GSB_api.model.Etat;

public interface EtatRepository extends JpaRepository<Etat, Long> {
}
