package com.veterinaria.cliente.repository;

import com.veterinaria.cliente.entity.Cliente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
