package com.example.livecoding03052024.repository;

import com.example.livecoding03052024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

