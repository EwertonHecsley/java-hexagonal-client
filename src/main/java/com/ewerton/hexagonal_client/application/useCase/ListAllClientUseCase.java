package com.ewerton.hexagonal_client.application.useCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.core.domain.port.out.ClientRepositoryPort;

@Service
public class ListAllClientUseCase {
    private final ClientRepositoryPort clientRepository;

    public ListAllClientUseCase(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> execute() {
        try {
            return clientRepository.listAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while listing clients", e);
        }
    }
}
