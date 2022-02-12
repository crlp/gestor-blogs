package com.reto.gestorblogs.service.impl;

import com.reto.gestorblogs.entity.Blog;
import com.reto.gestorblogs.entity.Post;
import com.reto.gestorblogs.exception.NotFoundException;
import com.reto.gestorblogs.exception.ValidationException;
import com.reto.gestorblogs.repository.PostRepository;
import com.reto.gestorblogs.service.PostService;
import com.reto.gestorblogs.util.BlogStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private BlogServiceImpl blogServiceImpl;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, BlogServiceImpl blogServiceImpl){
        this.postRepository = postRepository;
        this.blogServiceImpl = blogServiceImpl;
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new NotFoundException("post.notFound"));
    }

    @Override
    public Post save(Post post) {

        Blog blog = blogServiceImpl.findById(post.getBlog().getId());

        if(!blog.getStatus().equals(BlogStatusEnum.ACTIVO)) throw new ValidationException("blog.isNotActive");
        if(existAnotherPostToday(blog)) throw new ValidationException("post.existAnotherPostToday");

        return postRepository.save(post);
    }

    private boolean existAnotherPostToday(Blog blog){

        Optional<Post> optionalPost = postRepository.findFirstByBlogOrderByDateDesc(blog);

        if(optionalPost.isEmpty()) return false;

        long diffInMillies = Math.abs(new Date().getTime() - optionalPost.get().getDate().getTime());
        long diff = (diffInMillies / (1000 * 60 * 60 * 24)) % 365;

        return diff > 1 ? false : true;
    }
}
