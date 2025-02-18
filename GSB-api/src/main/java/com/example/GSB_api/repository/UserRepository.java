package com.example.GSB_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GSB_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
