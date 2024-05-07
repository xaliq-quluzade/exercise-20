package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;

public record CommentPostResponseDto(String title, String content, LocalDateTime createdDate,
                                     PostUserResponseDto user) {

}
