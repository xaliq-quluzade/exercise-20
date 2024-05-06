package com.example.livecoding03052024.repository;

import com.example.livecoding03052024.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

