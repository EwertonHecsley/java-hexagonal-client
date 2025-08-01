package com.ewerton.hexagonal_client.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewerton.hexagonal_client.application.useCase.CreateClientUseCase;
import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.infrastructure.controller.dto.CreateClientRequest;
import com.ewerton.hexagonal_client.infrastructure.controller.dto.CreateClientResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final CreateClientUseCase useCase;

    public ClientController(CreateClientUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<CreateClientResponse> handlerCreate(@RequestBody @Valid CreateClientRequest request) {
        Client client = this.useCase.execute(request.name(), request.email());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateClientResponse("Client created successfully", client));
    }
}
