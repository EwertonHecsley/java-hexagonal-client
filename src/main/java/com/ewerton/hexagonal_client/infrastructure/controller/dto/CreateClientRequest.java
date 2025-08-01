package com.ewerton.hexagonal_client.infrastructure.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateClientRequest(
        @NotBlank(message = "Name cannot be blank") String name,

        @NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email) {
}
