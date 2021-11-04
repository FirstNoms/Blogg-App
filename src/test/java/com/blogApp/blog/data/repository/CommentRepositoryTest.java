package com.blogApp.blog.data.repository;

import com.blogApp.blog.data.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts={"/db/insert.sql"})    //link up your comment database values with the comment test.
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testThatWeHaveAFunctionalCommentRepository(){
        Comment comment = new Comment();
        assertThat(comment.getId()).isNull();
        comment.setBody("This is the Body");
        comment.setName("This indicates the Name");
        commentRepository.save(comment);
        assertThat(comment.getId()).isNotNull();
    }

    @Test
    void testToFindCommentById(){
        Comment comment1  = commentRepository.findById(10l).orElse(null);
        assertThat(comment1.getId()).isNotNull();
        assertThat(comment1.getName()).isEqualTo("Chinomso");
    }
}