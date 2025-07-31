package com.ewerton.hexagonal_client.infrastructure.peristence.mapper;

import com.ewerton.hexagonal_client.core.domain.model.Client;
import com.ewerton.hexagonal_client.infrastructure.peristence.ClientEntity;

public class ClientMapper {
    public static ClientEntity toEntity(Client entity) {
        return ClientEntity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    public static Client toDomain(ClientEntity client) {
        return new Client(client.getName(), client.getEmail(), client.getId());
    }
}
