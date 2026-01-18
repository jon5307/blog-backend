package com.jon5307.blog.post;

import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public List<PostListResponse> list() {
        return postService.getPostList();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @PostMapping("/create")
    public void createPost(@RequestParam String title, @RequestParam String content) {
        postService.createPost(title, content);
    }
}
