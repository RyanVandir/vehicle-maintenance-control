package com.ryan.vehicle_maintenance_control.application.usecase;

import com.ryan.vehicle_maintenance_control.application.ports.in.VehicleUseCasePort;
import com.ryan.vehicle_maintenance_control.application.ports.out.VehicleRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleUseCase implements VehicleUseCasePort {

    private final VehicleRepositoryPort service;

    @Override
    public Vehicle created(Vehicle vehicle) {
        return service.save(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return service.findAll();
    }
}
