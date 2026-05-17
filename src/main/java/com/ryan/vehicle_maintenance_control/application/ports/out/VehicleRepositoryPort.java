package com.ryan.vehicle_maintenance_control.application.ports.out;

import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;

import java.util.List;

public interface VehicleRepositoryPort {
    VehicleModel save(VehicleModel model);

    List<VehicleModel> findAll();
}
