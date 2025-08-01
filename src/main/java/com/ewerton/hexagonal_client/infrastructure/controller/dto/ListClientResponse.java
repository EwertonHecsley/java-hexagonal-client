package com.ewerton.hexagonal_client.infrastructure.controller.dto;

import java.util.List;

public record ListClientResponse(String message, List<ClientResponse> clients) {
}