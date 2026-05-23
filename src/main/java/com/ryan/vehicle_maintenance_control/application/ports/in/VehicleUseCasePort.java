package com.ryan.vehicle_maintenance_control.application.ports.in;

import com.ryan.vehicle_maintenance_control.domain.model.Vehicle;

import java.util.List;

public interface VehicleUseCasePort {
    Vehicle created(Vehicle vehicle);
    List<Vehicle> findAll();
}
