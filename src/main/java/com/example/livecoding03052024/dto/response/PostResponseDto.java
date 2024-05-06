package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;

public record PostResponseDto(String title, String content, LocalDateTime createdDate) {
}
