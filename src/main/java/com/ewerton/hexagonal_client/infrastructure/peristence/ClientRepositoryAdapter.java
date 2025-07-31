package com.ewerton.hexagonal_client.infrastructure.peristence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.core.domain.port.out.ClientRepositoryPort;
import com.ewerton.hexagonal_client.infrastructure.peristence.mapper.ClientMapper;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final JpaClientRepository repository;

    public ClientRepositoryAdapter(JpaClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client create(Client client) {
        ClientEntity entity = ClientMapper.toEntity(client);
        ClientEntity savedEntity = repository.save(entity);
        return ClientMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Client> findById(UUID id) {

        Optional<ClientEntity> entity = repository.findById(id.toString());
        if (entity.isEmpty()) {
            return Optional.empty();
        }

        Client client = ClientMapper.toDomain(entity.get());
        return Optional.of(client);
    }

    @Override
    public List<Client> listAll() {
        List<ClientEntity> entities = repository.findAll();
        return entities.stream()
                .map(ClientMapper::toDomain)
                .toList();
    }
}
