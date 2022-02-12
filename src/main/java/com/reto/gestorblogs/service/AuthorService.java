package com.reto.gestorblogs.service;

import com.reto.gestorblogs.entity.Author;

public interface AuthorService {

    Author getById(Long authorId);
    Author save(Author author);
    void delete(Long authorId);
}
