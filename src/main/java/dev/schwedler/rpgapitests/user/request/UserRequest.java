package dev.schwedler.rpgapitests.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        String firstName,
        String lastName,
        @NotBlank
        @Email(message = "Invalid Email")
        String email
        ) {

        public UserRequest {
                if (email != null) email = email.trim().toLowerCase();
        }
}
