package com.ewerton.hexagonal_client.infrastructure.peristence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<ClientEntity, String> {

}
