package com.ryan.vehicle_maintenance_control.domain.model;

import com.ryan.vehicle_maintenance_control.domain.enums.MaintenanceCategory;
import com.ryan.vehicle_maintenance_control.domain.exception.InvalidVehicleException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Maintenance {
    private static final int GARGALO_KM_ALERTA = 100; // ALERTA FALTANDO 100KM
    private static final int GARGALO_DIAS_ALERTA = 7; // ALERTA FALTANDO 7 DIAS

    private String name;
    private Integer kmProximaTroca;
    private LocalDate proximaTroca;

    private Vehicle vehicle;

    private Set<MaintenanceCategory> categories;

    public Maintenance(String name, Integer kmProximaTroca, LocalDate proximaTroca, Set<MaintenanceCategory> categories, Vehicle vehicle) {
        validate(vehicle, name, kmProximaTroca, proximaTroca);
        this.name = name;
        this.kmProximaTroca = kmProximaTroca;
        this.proximaTroca = proximaTroca;
        this.categories = categories;
    }

    public boolean shouldNotify(LocalDate currentDate) {

        long kmRestantes = kmProximaTroca - vehicle.getKmAtual();
        // validação da janela de km
        boolean alertKm = kmRestantes <= GARGALO_KM_ALERTA && kmRestantes > 0;
        // validação da janela de tempo (data)
        long diasRestantes = ChronoUnit.DAYS.between(currentDate, proximaTroca);
        boolean alertDate = diasRestantes <= GARGALO_DIAS_ALERTA && diasRestantes > 0;

        return alertKm || alertDate;
    }

    private void validate(Vehicle vehicle, String name, Integer kmProximaTroca, LocalDate proximaTroca) {

        if (vehicle == null) {
            throw new InvalidVehicleException("Vehicle cannot be null");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (kmProximaTroca != null && kmProximaTroca <= 0) {
            throw new IllegalArgumentException("Intervalo KM inválido");
        }

        if (proximaTroca != null && !proximaTroca.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Intervalo meses inválido");
        }
    }
}
