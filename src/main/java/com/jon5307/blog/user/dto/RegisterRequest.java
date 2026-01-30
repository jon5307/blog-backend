package com.jon5307.blog.user.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
