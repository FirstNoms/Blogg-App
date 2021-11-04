package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findByPostId(Long id) {
        return postRepository.findById(id).orElse(null);
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
