package com.reto.gestorblogs.service;

import com.reto.gestorblogs.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog findById(Long blogId);
    Blog saveBlog(Blog request);
    List<Blog> findAll();

}
