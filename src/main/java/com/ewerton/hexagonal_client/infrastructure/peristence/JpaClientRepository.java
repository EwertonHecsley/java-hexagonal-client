package com.ewerton.hexagonal_client.infrastructure.peristence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<ClientEntity, UUID> {

}
