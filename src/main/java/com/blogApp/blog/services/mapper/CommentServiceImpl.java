package com.blogApp.blog.services.mapper;

import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.model.Comment;
import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.repository.CommentRepository;
import com.blogApp.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findByCommentId(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Post findCommentByTitle(String title) {
        return null;
    }

    @Override
    public List<Post> findCommentByAuthor() {
        return null;
    }

    @Override
    public void deleteComment(Long id) {
            commentRepository.deleteById(id);
    }
}
