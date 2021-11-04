package com.blogApp.blog.data.repository;

import com.blogApp.blog.data.model.Comment;
import com.blogApp.blog.data.model.Post;
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
@Sql(scripts={"/db/insert.sql"})    //link up your post database values with the postRepository test.
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testThatWeHaveAPostDatabaseThatCanSaveAPost(){
        Post post = new Post();
        assertThat(post.getId()).isNull();
        post.setTitle("Desiderata");
        post.setPostBody("Go Placidly amid the noise and haste and remember what peace there may be in silence.");
        postRepository.save(post);
        assertThat(post.getId()).isNotNull();

    }
}