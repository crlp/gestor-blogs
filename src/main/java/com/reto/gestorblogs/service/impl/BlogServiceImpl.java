package com.reto.gestorblogs.service.impl;

import com.reto.gestorblogs.entity.Author;
import com.reto.gestorblogs.entity.Blog;
import com.reto.gestorblogs.exception.NotFoundException;
import com.reto.gestorblogs.exception.ValidationException;
import com.reto.gestorblogs.repository.BlogRepository;
import com.reto.gestorblogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;
    private AuthorServiceImpl authorServiceImpl;

    @Autowired
    public BlogServiceImpl(
            BlogRepository blogRepository,
            AuthorServiceImpl authorServiceImpl){
        this.blogRepository = blogRepository;
        this.authorServiceImpl = authorServiceImpl;
    }

    @Override
    public Blog findById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException("blog.notFound"));
    }

    @Override
    public Blog saveBlog(Blog request) {

        Author author = authorServiceImpl.getById(request.getAuthor().getId());
        if(hasMore3Blogs(author))
            throw new ValidationException("Un usuario no puede tener mas de 3 Blogs");
        if(!authorServiceImpl.isOlderThan18(author))
            throw new ValidationException("Un usuario menor a 18 anos no puede tener blog");

        return blogRepository.save(request);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    private boolean hasMore3Blogs(Author author){
        return blogRepository.countByAuthor(author) >= 3;
    }

}
