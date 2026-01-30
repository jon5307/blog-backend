package com.jon5307.blog.user.dto;

public record LoginRequest(
        String username,
        String password
) {
}
