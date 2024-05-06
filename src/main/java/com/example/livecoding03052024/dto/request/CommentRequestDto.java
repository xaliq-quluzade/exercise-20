package com.example.livecoding03052024.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentRequestDto(
        @NotNull
        @NotBlank
        @Size(min = 5, max = 100)
        String content,

        Integer postId
) {
}
