package com.ewerton.hexagonal_client.application.useCase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.core.domain.port.out.ClientRepositoryPort;

@Service
public class FindClientUseCase {
    private final ClientRepositoryPort clientRepository;

    public FindClientUseCase(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> execute(UUID clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }
        return clientRepository.findById(clientId);
    }
}
