package com.veterinaria.cliente.service;

import com.veterinaria.cliente.dto.ClienteDTO;
import com.veterinaria.cliente.entity.Cliente;
import com.veterinaria.cliente.mapper.ClienteMapper;
import com.veterinaria.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> getClientesAsDTO() {
        return getClientes()
                .stream()
                .map(ClienteMapper::toClienteDTO)
                .toList();
    }

    @Override
    public ClienteDTO saveClienteAsDTO(ClienteDTO clienteDTO) {
        var cliente = ClienteMapper.toCliente(clienteDTO);
        var savedCliente = saveCliente(cliente);
        return ClienteMapper.toClienteDTO(savedCliente);
    }

    @Override
    public ClienteDTO getClienteByEmailAsDTO(String email) {
        var cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent())
            return ClienteMapper.toClienteDTO(cliente.get());
        else
            return null;
    }

    @Override
    public void deleteClienteAsDTO(Long id) {
        clienteRepository.deleteById(id);
    }

}
