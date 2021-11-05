package com.blogApp.blog.data.repository;

import com.blogApp.blog.data.model.Comment;
import com.blogApp.blog.data.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
//@Sql(scripts={"/db/insert.sql"})    //link up your post database values with the postRepository test.
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

    @Test
    void testToFindPostById(){
        Post post2 = postRepository.findById(13l).orElse(null);
        assertThat(post2.getId()).isNotNull();
        assertThat(post2.getAuthor()).isEqualTo("Chinomso");
        assertThat(post2.getPostBody()).isNotNull();
    }

    @Test
    void testToDeleteAPost(){
        int size = postRepository.findAll().size();
        postRepository.deleteById(14L);
        assertThat(postRepository.findAll().size()).isEqualTo(size-1);
    }

//    @Test
//    void testToUpdatePostBody(){
//        Post post3 = postRepository.findById(13l).orElse(null);
//        post3.setPostBody("Its great to be in the Tech world");
//        Post savedPost = postRepository.save(post3);
//        savedPost.setPostBody("it is well");
//        assertThat(savedPost.getPostBody()).isEqualTo("it is well");
//    }

    @Test
    void deleteAll(){
        Post post1 = new Post();
        Post post2 = new Post();
        post1.setPostBody("Takes care of the product from the idea to production");
        post1.setTitle("Product Management");
        post2.setPostBody("Takes care of writing programs on the computer");
        post2.setTitle("Software Development");
        Post savedPost = postRepository.save(post1);
        Post savedPost2 = postRepository.save(post2);
        assertThat(post1.getId()).isNotNull();
        assertThat(post2.getId()).isNotNull();
        postRepository.deleteAll();
        List<Post> foundPost = postRepository.findAll();
        assertThat(foundPost.size()).isEqualTo(0);
    }


}