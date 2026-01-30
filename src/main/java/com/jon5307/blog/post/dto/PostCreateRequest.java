package com.jon5307.blog.post.dto;

public record PostCreateRequest(
        String title,
        String content,
        Long categoryId
) {
}
