package com.example.livecoding03052024.repository;

import com.example.livecoding03052024.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
