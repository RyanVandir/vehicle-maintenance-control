package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntity {
    @Id
    String marca;
    String modelo;
    Integer ano;
    String motor;
    Integer quilometragemAtual;
}
