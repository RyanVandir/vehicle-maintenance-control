package com.ryan.vehicle_maintenance_control.application.ports.out;

import com.ryan.vehicle_maintenance_control.domain.model.Maintenance;

import java.util.List;

public interface MaintenanceRepositoryPort {
    Maintenance save(Maintenance maintenance);
    List<Maintenance> findAll();
    void verify(Maintenance maintenance);
}
