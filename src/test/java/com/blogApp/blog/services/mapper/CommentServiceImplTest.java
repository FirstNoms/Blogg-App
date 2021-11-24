package com.blogApp.blog.services.mapper;

import com.blogApp.blog.data.model.Comment;
import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.repository.CommentRepository;
import com.blogApp.blog.data.repository.PostRepository;
import com.blogApp.blog.services.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommentServiceImplTest {

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    CommentServiceImpl commentService;


    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToSaveComment(){
        Comment comment = new Comment();
        comment.setId(13l);
        comment.setName("Lola Lolu");
        comment.setBody("This is a great Article Nomso");
        when(commentService.saveComment(comment)).thenReturn(comment);
        commentService.saveComment(comment);
        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    void testToFindPostById(){
        Comment comment = new Comment();
        comment.setId(13l);
        commentService.saveComment(comment);
        when(commentService.findByCommentId(13l)).thenReturn(Optional.of(comment));
        commentService.findByCommentId(13l);
        verify(commentRepository, times(1)).findById(13l);
    }

    @Test
        void testToDeleteCommentById(){
        Comment comment = new Comment();
        comment.setId(13l);
        commentService.saveComment(comment);
        commentService.deleteComment(13l);
        when(commentService.findByCommentId(13l)).thenReturn(null);
        commentRepository.findById(13L);
        verify(commentRepository, times(1)).findById(13l);

        }
}