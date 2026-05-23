package com.ryan.vehicle_maintenance_control.application.ports.out;

import com.ryan.vehicle_maintenance_control.domain.model.Vehicle;

import java.util.List;

public interface VehicleRepositoryPort {
    Vehicle save(Vehicle model);

    List<Vehicle> findAll();
}
