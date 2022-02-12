package com.reto.gestorblogs.service.impl;

import com.reto.gestorblogs.entity.Comment;
import com.reto.gestorblogs.entity.Post;
import com.reto.gestorblogs.exception.ValidationException;
import com.reto.gestorblogs.repository.CommentRepository;
import com.reto.gestorblogs.service.CommentService;
import com.reto.gestorblogs.util.PostStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostServiceImpl postService;

    public CommentServiceImpl(
            CommentRepository commentRepository,
            PostServiceImpl postService){
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    @Override
    public Comment save(Comment comment) {

        Post post = postService.findById(comment.getPost().getId());
        //Solo se pueden registrar comentarios en post en estado publicado.
        if(!post.getStatus().equals(PostStatusEnum.PUBLICADO))
            throw new ValidationException("El post no se encuentra Publicado");
        return commentRepository.save(comment);
    }
}
