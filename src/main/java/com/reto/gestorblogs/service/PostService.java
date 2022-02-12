package com.reto.gestorblogs.service;


import com.reto.gestorblogs.entity.Post;

public interface PostService {

    Post findById(Long postId);
    Post save(Post post);
}
