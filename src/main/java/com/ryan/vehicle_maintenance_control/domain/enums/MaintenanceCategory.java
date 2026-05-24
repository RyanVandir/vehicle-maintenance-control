package com.ryan.vehicle_maintenance_control.domain.enums;

public enum MaintenanceCategory {
    MOTOR_TRANSMISSAO("Motor e Transmissão"),
    ARREFECIMENTO("Sistema de Arrefecimento"),
    FREIOS_SUSPENSAO("Freios e Suspensão"),
    RODAGEM("Rodagem e Pneus"),
    ELETRICA_CLIMATIZACAO("Elétrica e Climatização"),
    ESTETICA_UTILIDADES("Estética e Utilidades");

    private String description;

    MaintenanceCategory(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
