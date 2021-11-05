package com.blogApp.blog.services;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findByPostId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post findPostByTitle(String title) {
        return null;

//        Post post = postRepository.findPostByTitle(title);
//        if(post == null){
//            throw new IllegalStateException("This title doesnt exist");
//        }
    }

    @Override
    public List<Post> findPostByAuthor() {
        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Post updatePost(Long id, PostUpdateDto postUpdate) {
        return null;
    }
}
