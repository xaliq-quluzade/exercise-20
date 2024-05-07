package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;

public record CommentResponseDto(String content, LocalDateTime createdDate, CommentPostResponseDto post) {
}
