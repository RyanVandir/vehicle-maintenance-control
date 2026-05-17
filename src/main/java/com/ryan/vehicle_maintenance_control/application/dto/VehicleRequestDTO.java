package com.ryan.vehicle_maintenance_control.application.dto;

public record VehicleRequestDTO(
        String marca,
        String modelo,
        Integer ano,
        String motor,
        Integer quilometragemAtual
) {
}
