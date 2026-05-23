package com.ryan.vehicle_maintenance_control.domain.model;

import java.util.Set;

public class Maintenance {

    private String name;
    private Integer intervaloKm;
    private Integer intervaloMeses;

    private Set<MaintenanceCategory> categories;

    public Maintenance() {
    }

    public Maintenance(String name, Integer intervaloKm, Integer intervaloMeses, Set<MaintenanceCategory> categories) {
        validate(name, intervaloKm, intervaloMeses);
        this.name = name;
        this.intervaloKm = intervaloKm;
        this.intervaloMeses = intervaloMeses;
        this.categories = categories;
    }

    private void validate(String name, Integer intervaloKm, Integer intervaloMeses) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (intervaloKm != null && intervaloKm <= 0) {
            throw new IllegalArgumentException("Intervalo KM inválido");
        }

        if (intervaloMeses != null && intervaloMeses <= 0) {
            throw new IllegalArgumentException("Intervalo meses inválido");
        }
    }
}
