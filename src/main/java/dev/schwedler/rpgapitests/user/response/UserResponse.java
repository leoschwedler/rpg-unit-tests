package dev.schwedler.rpgapitests.user.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
