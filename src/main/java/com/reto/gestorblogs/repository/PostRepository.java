package com.reto.gestorblogs.repository;

import com.reto.gestorblogs.entity.Blog;
import com.reto.gestorblogs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<Post> findFirstByBlogOrderByDateDesc(Blog blog);
}
