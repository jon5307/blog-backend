package com.jon5307.blog.post.dto;

import java.time.LocalDateTime;

public record PostListResponse(
        Integer id,
        String title,
        String summary,
        LocalDateTime createdDate
) {}
