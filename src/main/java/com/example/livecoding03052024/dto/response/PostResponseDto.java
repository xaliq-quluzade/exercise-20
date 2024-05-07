package com.example.livecoding03052024.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record PostResponseDto(String title, String content, LocalDateTime createdDate, PostUserResponseDto user,
                              Set<PostCommentResponseDto> comments) {
}
