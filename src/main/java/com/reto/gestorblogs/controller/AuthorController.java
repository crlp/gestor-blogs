package com.reto.gestorblogs.controller;

import com.reto.gestorblogs.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController( AuthorService authorService){
        this.authorService = authorService;
    }

    @DeleteMapping("/{authorId}")
    public void delete (@PathVariable Long authorId){
        this.authorService.delete(authorId);
    }
}
