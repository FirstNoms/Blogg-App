package com.blogApp.blog.services;

import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.model.Comment;
import com.blogApp.blog.data.model.Post;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment saveComment(Comment comment);
    Optional<Comment> findByCommentId(Long id);
    Post findCommentByTitle(String title);
    List<Post> findCommentByAuthor();
    void deleteComment(Long id);


}
