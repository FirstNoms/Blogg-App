package com.blogApp.blog.data.repository;

import com.blogApp.blog.data.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
