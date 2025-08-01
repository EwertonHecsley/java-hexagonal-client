package com.ewerton.hexagonal_client.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewerton.hexagonal_client.application.useCase.CreateClientUseCase;
import com.ewerton.hexagonal_client.core.domain.model.Client;

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
    public ResponseEntity<Client> handlerCreate(@RequestBody Client entity) {
        Client result = this.useCase.execute(entity.getName(), entity.getEmail());
        return ResponseEntity.ok().body(result);
    }
}
