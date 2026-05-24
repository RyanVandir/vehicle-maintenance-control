package com.ryan.vehicle_maintenance_control.application.ports.in;

import com.ryan.vehicle_maintenance_control.domain.model.Maintenance;

import java.util.List;

public interface MaintenanceUseCasePort {
    Maintenance created(Maintenance maintenance);
    List<Maintenance> findAll();
}
