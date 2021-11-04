package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Override
    public Post savePost(Post post) {
        return null;
    }

    @Override
    public Post findByPostId(Long id) {
        return null;
    }

    @Override
    public Post findPostByTitle(String title) {
        return null;
    }

    @Override
    public List<Post> findPostByAuthor() {
        return null;
    }

    @Override
    public void deletePost(String id) {

    }

    @Override
    public Post updatePost(Long id, PostUpdateDto postUpdate) {
        return null;
    }
}
