package com.reto.gestorblogs.repository;

import com.reto.gestorblogs.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
