package com.jon5307.blog.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(int id) {
        return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Post not found"));
    }

    public void createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedDate(LocalDateTime.now());
        postRepository.save(post);
    }
}
