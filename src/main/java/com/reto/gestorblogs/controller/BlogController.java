package com.reto.gestorblogs.controller;

import com.reto.gestorblogs.entity.Blog;
import com.reto.gestorblogs.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAll(){
        return blogService.findAll();
    }

    @PostMapping
    public Blog saveBlog(@RequestBody Blog request){
        return blogService.saveBlog(request);
    }
}
