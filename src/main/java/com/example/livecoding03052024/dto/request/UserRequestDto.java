package com.example.livecoding03052024.dto.request;

import jakarta.validation.constraints.*;

public record UserRequestDto(
        @NotBlank
        @Size(min = 7, max = 15)
        String username,

        @NotBlank
        @Email
        String email,

        @NotNull
        @NotBlank
        @Size(min = 10, max = 15)
        @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$", message = "Password must contain two uppercase letters, one special character, two digits, and three lowercase letters.")
        String password
) {
}
