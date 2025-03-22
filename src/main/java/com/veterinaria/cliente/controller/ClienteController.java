package com.veterinaria.cliente.controller;

import com.veterinaria.cliente.dto.ClienteDTO;
import com.veterinaria.cliente.service.ClienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/getClientes")
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        log.info("Obteniendo lista de clientes...");
        try {
            List<ClienteDTO> clientes = clienteService.getClientesAsDTO();
            log.info("Lista de clientes obtenida exitosamente. Total: {} clientes.", clientes.size());
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            log.error("Error al obtener la lista de clientes: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getCliente/{email}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable String email) {
        log.info("Obteniendo cliente con email: {}", email);
        try {
            ClienteDTO dto = clienteService.getClienteByEmailAsDTO(email);
            log.info("Cliente obtenido exitosamente: {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al obtener un cliente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ClienteDTO> addCliente(@RequestBody ClienteDTO clienteDTO) {
        log.info("Agregando cliente...");
        try {
            log.info("Datos del cliente: {}", clienteDTO);
            ClienteDTO dto = clienteService.saveClienteAsDTO(clienteDTO);
            log.info("Cliente agregado exitosamente");
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al guardar el cliente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long id) {
        log.info("Eliminando cliente con id: {}", id);
        try {
            clienteService.deleteClienteAsDTO(id);
            log.info("Cliente eliminado exitosamente");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error al eliminar el cliente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }


}
