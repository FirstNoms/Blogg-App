package com.blogApp.blog.controller;

import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/api/post")
    public Post createPost(@RequestBody Post post){

        return postService.savePost(post);
    }

    @GetMapping("/api/post/{id}")
    public Optional<Post> getPost(@PathVariable("id") Long id){
        return postService.findByPostId(id);
    }

    public Post deletePostById(@PathVariable Long id){
        return postService.deletePostById(id);
    }
//
//    @GetMapping("/api/posts/")
//    public List<Post> getAllPost(){
//        return postService.findAll();
//    }
}
