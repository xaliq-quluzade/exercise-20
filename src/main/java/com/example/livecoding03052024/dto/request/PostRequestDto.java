package com.example.livecoding03052024.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequestDto(
        @NotNull
        @Size(min = 3, max = 20)
        String title,

        @NotNull
        @Size(min = 30, max = 150)
        String content,

        Integer userId
) {
}
