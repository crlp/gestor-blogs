package com.reto.gestorblogs.service.impl;

import com.reto.gestorblogs.entity.Author;
import com.reto.gestorblogs.exception.NotFoundException;
import com.reto.gestorblogs.repository.AuthorRepository;
import com.reto.gestorblogs.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private BlogServiceImpl blogServiceImpl;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow( () -> new NotFoundException("authorId.NotFound"));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long authorId) {
        Author author = this.getById(authorId);
        this.authorRepository.delete(author);
    }

    public boolean isOlderThan18(Author author){
        long diffInMillies = Math.abs(new Date().getTime() - author.getBirthDate().getTime());
        long diff = (diffInMillies / (1000l * 60 * 60 * 24 * 365));
        return diff > 18;
    }
}
