package com.blogApp.blog.data.repository;

import com.blogApp.blog.data.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
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
}