package com.veterinaria.cliente.service;

import com.veterinaria.cliente.dto.ClienteDTO;
import com.veterinaria.cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getClientes();

    Optional<Cliente> getClienteById(Long id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(Long id);

    List<ClienteDTO> getClientesAsDTO();

    ClienteDTO saveClienteAsDTO(ClienteDTO clienteDTO);

    ClienteDTO getClienteByEmailAsDTO(String email);

    void deleteClienteAsDTO(Long id);
}
