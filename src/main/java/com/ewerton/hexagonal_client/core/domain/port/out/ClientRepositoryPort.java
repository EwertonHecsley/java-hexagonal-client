package com.ewerton.hexagonal_client.core.domain.port.out;

import java.util.List;
import java.util.UUID;

import com.ewerton.hexagonal_client.core.domain.model.Client;

public interface ClientRepositoryPort {
    Client create(Client client);

    List<Client> listAll();

    Client findById(UUID id);
}
