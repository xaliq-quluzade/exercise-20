package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;

public record UserPostResponseDto(String title, String content, LocalDateTime createdDate) {
}
