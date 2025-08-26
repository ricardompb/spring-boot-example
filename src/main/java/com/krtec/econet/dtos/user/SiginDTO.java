package com.krtec.econet.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SiginDTO(
        @NotBlank
        @Email(message = "{validation.email}")
        String email,
        @NotBlank
        String password
) {
}
