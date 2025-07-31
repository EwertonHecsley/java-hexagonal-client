package com.ewerton.hexagonal_client.application.useCase;

import org.springframework.stereotype.Service;

import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.core.domain.port.out.ClientRepositoryPort;

@Service
public class CreateClientUseCase {
    private final ClientRepositoryPort clientReposiory;

    public CreateClientUseCase(ClientRepositoryPort clientRepository) {
        this.clientReposiory = clientRepository;
    }

    public Client execute(String name, String email) {
        try {
            Client client = new Client(name, email);
            return clientReposiory.create(client);
        } catch (Exception e) {
            throw new RuntimeException("Error creating client: " + e.getMessage(), e);
        }
    }
}
