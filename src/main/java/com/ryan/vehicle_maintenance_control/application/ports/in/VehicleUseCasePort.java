package com.ryan.vehicle_maintenance_control.application.ports.in;

import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;

import java.util.List;

public interface VehicleUseCasePort {
    VehicleModel created(VehicleModel vehicleModel);
    List<VehicleModel> findAll();
}
