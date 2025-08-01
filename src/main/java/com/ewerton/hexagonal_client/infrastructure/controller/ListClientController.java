package com.ewerton.hexagonal_client.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewerton.hexagonal_client.application.useCase.ListAllClientUseCase;
import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.infrastructure.controller.dto.ClientResponse;
import com.ewerton.hexagonal_client.infrastructure.controller.dto.ListClientResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/client")
public class ListClientController {
    private final ListAllClientUseCase useCase;

    public ListClientController(ListAllClientUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<ListClientResponse> handlerList() {
        List<Client> clients = this.useCase.execute();
        List<ClientResponse> response = clients.stream()
                .map(client -> new ClientResponse(client.getId(), client.getName(), client.getEmail()))
                .toList();
        return ResponseEntity.ok(new ListClientResponse("Clients listed sucessfully", response));
    }

}
