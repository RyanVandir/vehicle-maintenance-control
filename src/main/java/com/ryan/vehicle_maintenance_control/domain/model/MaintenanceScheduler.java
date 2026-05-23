package com.ryan.vehicle_maintenance_control.domain.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MaintenanceScheduler {

    private static final int GARGALO_KM_ALERTA = 100; // ALERTA FALTANDO 100KM
    private static final int GARGALO_DIAS_ALERTA = 7; // ALERTA FALTANDO 7 DIAS

    private LocalDate dataProximaTroca;
    private Long kmProximaTroca;


    public boolean shouldNotify(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not null");
        }
        long kmRestantes = kmProximaTroca - vehicle.getKmAtual();
        // validação da janela de km
        boolean alertKm = kmRestantes <= GARGALO_KM_ALERTA && kmRestantes > 0;
        // validação da janela de tempo (data)
        long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), dataProximaTroca);
        boolean alertDate = diasRestantes <= GARGALO_DIAS_ALERTA && diasRestantes > 0;

        return alertKm || alertDate;
    }

    public MaintenanceScheduler(LocalDate dataProximaTroca, Long kmProximaTroca) {
        validate(dataProximaTroca, kmProximaTroca);
        this.dataProximaTroca = dataProximaTroca;
        this.kmProximaTroca = kmProximaTroca;
    }

    private void validate(LocalDate dataProximaTroca, Long kmProximaTroca) {
        if (dataProximaTroca == null || !dataProximaTroca.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Dia da próxima troca inválido");
        }
        if (kmProximaTroca == null || kmProximaTroca <= 0) {
            throw new IllegalArgumentException("Km da próxima troca inválido");
        }
    }
}
