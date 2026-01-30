package com.jon5307.blog.user.dto;

import java.time.LocalDateTime;


public record LoginResponse(
        String token,
        LocalDateTime expirationDate
) {
}
