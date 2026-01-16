package com.jon5307.blog.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    @GetMapping("/detail/{id}")
    public Post findOne(@PathVariable int id) {
        return postService.getPost(id);
    }
}
