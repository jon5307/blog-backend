package com.jon5307.blog.post;

import com.jon5307.blog.post.dto.PostDetailResponse;
import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public Page<PostListResponse> list(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
            ) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate"));
        Pageable pageable = PageRequest.of(page, size, Sort.by(sorts));
        return postService.getPostList(categoryId, pageable);
    }

    @GetMapping("/detail/{id}")
    public PostDetailResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping("/create")
    public void createPost(@RequestParam String title, @RequestParam String content, @RequestParam Long categoryId) {
        postService.createPost(title, content, categoryId);
    }
}
