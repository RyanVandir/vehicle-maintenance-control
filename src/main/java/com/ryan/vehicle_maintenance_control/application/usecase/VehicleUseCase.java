package com.ryan.vehicle_maintenance_control.application.usecase;

import com.ryan.vehicle_maintenance_control.application.ports.in.VehicleUseCasePort;
import com.ryan.vehicle_maintenance_control.application.ports.out.VehicleRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleUseCase implements VehicleUseCasePort {

    private final VehicleRepositoryPort service;

    @Override
    public VehicleModel created(VehicleModel vehicleModel) {
        return service.save(vehicleModel);
    }

    @Override
    public List<VehicleModel> findAll() {
        return service.findAll();
    }
}
