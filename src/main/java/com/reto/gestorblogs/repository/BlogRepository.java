package com.reto.gestorblogs.repository;

import com.reto.gestorblogs.entity.Author;
import com.reto.gestorblogs.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    int countByAuthor(Author author);
}
