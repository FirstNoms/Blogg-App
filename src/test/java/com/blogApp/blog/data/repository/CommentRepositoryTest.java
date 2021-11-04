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
    void testThatWeHaveACommentRepositoryThatCanSaveAComment(){
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
        Comment comment2 = commentRepository.findById(11l).orElse(null);
        Comment comment3 = commentRepository.findById(12l).orElse(null);
        assertThat(comment1.getId()).isNotNull();
        assertThat(comment2.getId()).isNotNull();
        assertThat(comment3.getId()).isNotNull();
        assertThat(comment1.getName()).isEqualTo("Chinomso");
        assertThat(comment2.getBody()).isEqualTo("I am a Software Developer");
        assertThat(comment3.getBody()).isEqualTo("I am a Front-end developer and designer");

    }

    @Test
    void testToDeleteComment(){
        //when
        Comment comment = commentRepository.findById(12l).orElse(null);
        //And
        assertThat(comment).isNotNull();
        commentRepository.delete(comment);
        //then
        Comment comment2 = commentRepository.findById(12l).orElse(null);
        assertThat(comment2).isNull();
    }
}