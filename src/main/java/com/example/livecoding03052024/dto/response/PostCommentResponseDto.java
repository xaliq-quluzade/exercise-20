package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;

public record PostCommentResponseDto(String content, LocalDateTime createdDate) {
}
