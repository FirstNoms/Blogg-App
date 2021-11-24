package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface PostService {
    Post savePost(Post post);
    Optional<Post> findByPostId(Long id);
    Post findPostByTitle(String title);
    List<Post> findPostByAuthor();
    void deletePost(Long id);
    Post updatePost(Long id, PostUpdateDto postUpdate);
}
