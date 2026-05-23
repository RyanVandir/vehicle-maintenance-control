package com.ryan.vehicle_maintenance_control.domain.model;

import com.ryan.vehicle_maintenance_control.domain.exception.InvalidVehicleException;
import java.time.Year;

public class Vehicle {

    private String marca;
    private String modelo;
    private Integer ano;
    private String motor;
    private Integer kmAtual;

    public void validate(String marca, String modelo, Integer ano, String motor, Integer quilometragemAtual) {
        if (marca == null || marca.isBlank()) {
            throw new InvalidVehicleException("Marca obrigatória");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new InvalidVehicleException("Modelo obrigatório");
        }
        if (ano == null) {
            throw new InvalidVehicleException("Ano obrigatório");
        }
        if (ano < 1900) {
            throw new InvalidVehicleException("Ano do carro deve ser acima de 1900");
        }
        if (ano >= Year.now().getValue()) {
            throw new InvalidVehicleException("Ano não pode ser maior que o ano atual");
        }
        if (motor == null || motor.isBlank()) {
            throw new InvalidVehicleException("Motor obrigatório");
        }
        if (motor.trim().length() <= 3) {
            throw new InvalidVehicleException("Motor deve ter no mínimo 3 caracteres");
        }
        if (quilometragemAtual == null) {
            throw new InvalidVehicleException("Km obrigatório");
        }
        if (quilometragemAtual <= 0) {
            throw new InvalidVehicleException("Km não pode ser negativo");
        }
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

    public Integer getKmAtual() {
        return kmAtual;
    }

    public Vehicle(String marca, String modelo, Integer ano, String motor, Integer kmAtual) {
        validate(marca, modelo, ano, motor, kmAtual);
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.kmAtual = kmAtual;
    }
}
