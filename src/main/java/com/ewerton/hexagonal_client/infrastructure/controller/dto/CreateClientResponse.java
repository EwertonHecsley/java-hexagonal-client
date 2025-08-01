package com.ewerton.hexagonal_client.infrastructure.controller.dto;

import com.ewerton.hexagonal_client.core.domain.model.Client;

public record CreateClientResponse(String message, Client client) {
}
