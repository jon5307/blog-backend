package com.jon5307.blog.post;

import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public Page<PostListResponse> list(@RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        return postService.getPostList(page);
    }

    @GetMapping("/detail/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @PostMapping("/create")
    public void createPost(@RequestParam String title, @RequestParam String content) {
        postService.createPost(title, content);
    }
}
