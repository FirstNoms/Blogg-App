package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post savePost(Post post);
    Optional<Post> findByPostId(Long id);
    Post findPostByTitle(String title);
    List<Post> findPostByAuthor();
    void deletePost(Long id);
    Post updatePost(Long id, PostUpdateDto postUpdate);
}
