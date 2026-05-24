package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.service;

import com.ryan.vehicle_maintenance_control.application.ports.out.MaintenanceRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.Maintenance;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements MaintenanceRepositoryPort {

    private final MaintenanceRepository repository;

    @Override
    public Maintenance save(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    @Override
    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    @Override
    public void verify(Maintenance maintenance) {
            if (maintenance.shouldNotify(LocalDate.now())){
                System.out.println("Enviar notificação");
            }
       }
    }
