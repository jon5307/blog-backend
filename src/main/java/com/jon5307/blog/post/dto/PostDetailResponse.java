package com.jon5307.blog.post.dto;

import com.jon5307.blog.category.dto.CategoryResponse;

import java.time.LocalDateTime;

public record PostDetailResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdDate,
        CategoryResponse category
) {
    public static PostDetailResponse from(com.jon5307.blog.post.Post post) {
        return new PostDetailResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedDate(),
                CategoryResponse.from(post.getCategory())
        );
    }
}