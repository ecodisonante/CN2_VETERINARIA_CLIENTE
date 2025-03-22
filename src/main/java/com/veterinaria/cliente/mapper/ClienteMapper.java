package com.veterinaria.cliente.mapper;

import com.veterinaria.cliente.dto.ClienteDTO;
import com.veterinaria.cliente.entity.Cliente;

public class ClienteMapper {

    private ClienteMapper() {}

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getName(),
                cliente.getRut(),
                cliente.getEmail(),
                cliente.getIsAdmin()
        );
    }

    public static Cliente toCliente(ClienteDTO dto) {
        return new Cliente(
                dto.id(),
                dto.name(),
                dto.rut(),
                dto.email(),
                dto.isAdmin()
        );
    }
}
