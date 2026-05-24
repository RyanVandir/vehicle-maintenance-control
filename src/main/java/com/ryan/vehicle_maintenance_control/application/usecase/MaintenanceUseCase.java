package com.ryan.vehicle_maintenance_control.application.usecase;

import com.ryan.vehicle_maintenance_control.application.ports.in.MaintenanceUseCasePort;
import com.ryan.vehicle_maintenance_control.application.ports.out.MaintenanceRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceUseCase implements MaintenanceUseCasePort {

    private final MaintenanceRepositoryPort service;

    @Override
    public Maintenance created(Maintenance maintenance) {
        return service.save(maintenance);
    }

    @Override
    public List<Maintenance> findAll() {
        return service.findAll();
    }
}
