package com.blogApp.blog.services;

import com.blogApp.blog.data.dto.PostDto;
import com.blogApp.blog.data.model.Post;
import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.repository.PostRepository;
import com.blogApp.blog.services.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

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
//            throw new IllegalStateException("This title doesn't exist");
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
       Optional<Post> post = postRepository.findById(id);
       if(postUpdate == null){
           throw new IllegalArgumentException("Post cannot be empty");
       }
       if(post.isPresent()){
           Post seenPost = post.get();
           postMapper.mapPostDtoToPost(postUpdate,seenPost);
           return postRepository.save(seenPost);
       }else{
           throw new IllegalArgumentException("Post with this Id doesnt exist");
       }
    }

    @Override
    public Post deletePostById(Long id) {
        return null;
    }
}
