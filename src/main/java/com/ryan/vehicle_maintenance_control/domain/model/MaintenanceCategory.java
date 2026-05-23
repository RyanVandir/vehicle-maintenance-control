package com.ryan.vehicle_maintenance_control.domain.model;

import com.ryan.vehicle_maintenance_control.domain.exception.InvalidVehicleException;

public class MaintenanceCategory {

    private String description;

    public MaintenanceCategory(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    private void validate(String description){
        if (description.isBlank()) {
            throw new InvalidVehicleException("Descrição inválida");
        }
    }
}
