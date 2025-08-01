package com.ewerton.hexagonal_client.infrastructure.controller.dto;

import java.util.List;

import com.ewerton.hexagonal_client.core.domain.model.Client;

public record ListClientResponse(String message, List<Client> clients) {
}