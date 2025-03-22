package com.veterinaria.cliente.dto;

public record ClienteDTO(
        Long id,
        String name,
        String rut,
        String email,
        Boolean isAdmin
) {}
