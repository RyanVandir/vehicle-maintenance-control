package com.ryan.vehicle_maintenance_control.domain.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VehicleModel {

    private static final int GARGALO_KM_ALERTA = 100; // ALERTA FALTANDO 100KM
    private static final int GARGALO_DIAS_ALERTA = 7; // ALERTA FALTANDO 7 DIAS

    String marca;
    String modelo;
    Integer ano;
    String motor;
    Integer quilometragemAtual;

    public boolean deveNotificar(int kmAtual, int kmProximaTroca, LocalDate dataAtual, LocalDate dataProximaTroca) {
        int kmRestante = kmProximaTroca - kmAtual;
        // validação da janela de km
        boolean alertaKm = kmRestante <= GARGALO_KM_ALERTA && kmRestante > 0;
        // validação da janela de tempo (data)
        long diasRestantes = ChronoUnit.DAYS.between(dataAtual, dataProximaTroca);
        boolean alertaData = diasRestantes <= GARGALO_DIAS_ALERTA && diasRestantes > 0;

        return alertaKm || alertaData;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMotor() {
        return motor;
    }

    public Integer getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public VehicleModel(String marca, String modelo, Integer ano, String motor, Integer quilometragemAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.quilometragemAtual = quilometragemAtual;
    }
}
