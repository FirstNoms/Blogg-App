package com.blogApp.blog.services;

import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.repository.PostRepository;
import com.blogApp.blog.services.mapper.PostMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class PostServiceImplTest {
    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Mock
    PostMapper postMapper;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToSavePost(){
        Post post = new Post();
        post.setTitle("Product Management");
        post.setAuthor("Chinomso");
        post.setPostBody("Oga, Go placidly amid the noise and haste!");
        when(postService.savePost(post)).thenReturn(post);
        postService.savePost(post);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void testToFindPostById(){
        Post post = new Post();
        post.setId(13l);
        postService.savePost(post);
        when(postService.findByPostId(13l)).thenReturn(Optional.of(post));
        postService.findByPostId(13l);
        verify(postRepository, times(1)).findById(13l);
    }

    @Test
    void testToDeletePostById(){
        Post post = new Post();
        post.setId(13l);
        postService.savePost(post);
        postService.deletePost(13l);
        when(postService.findByPostId(13l)).thenReturn(null);
        postRepository.findById(13L);
        verify(postRepository, times(1)).findById(13l);
    }

    @Test
    void testToUpdatePost(){
        Post post = new Post();
        post.setId(13l);
        post.setTitle("BootStrapping");
        post.setPostBody("I'm interested in bootstrapping");
        when(postService.savePost(post)).thenReturn(post);
        postService.savePost(post);

        PostUpdateDto postUpdateDto = new PostUpdateDto();
        postUpdateDto.setTitle("Baby Sitting");

        when(postMapper.mapPostDtoToPost(postUpdateDto, post)).then((e) ->{
            post.setTitle(postUpdateDto.getTitle());
            return null;
        });
        when(postRepository.findById(13l)).thenReturn(Optional.of(post));
        postService.updatePost(13l,postUpdateDto);

        verify(postRepository, times(2)).save(post);
        verify(postRepository, times(1)).findById(13l);
    }
}