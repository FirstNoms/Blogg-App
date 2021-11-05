package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceImplTest {
    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostServiceImpl postServiceImpl;

    @BeforeEach
    void setUp() {
        postServiceImpl = new PostServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToSavePost(){
        Post post = new Post();
        post.setTitle("Product Management");
        post.setAuthor("Chinomso");
        post.setPostBody("Oga, Go placidly amid the noise and haste!");
        when(postServiceImpl.savePost(post)).thenReturn(post);
        postServiceImpl.savePost(post);
        verify(postRepository, times(1)).save(post);
    }

}