package com.ewerton.hexagonal_client.infrastructure.controller.dto;

import java.util.UUID;

public record ClientResponse(UUID id, String name, String email) {
}
