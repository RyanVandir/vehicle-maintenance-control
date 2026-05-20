package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.service;

import com.ryan.vehicle_maintenance_control.application.mapper.VehicleMapper;
import com.ryan.vehicle_maintenance_control.application.ports.out.VehicleRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.exception.DatabaseException;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServicePersistence implements VehicleRepositoryPort {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    @Override
    public VehicleModel save(VehicleModel vehicleModel) {
        try {
            return mapper.toModel(
                    repository.save(
                            mapper.toEntity(vehicleModel)
                    )
            );
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao criar veículo");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar o banco de dados");
        }
    }

    @Override
    public List<VehicleModel> findAll() {
        return mapper.toModels(
                repository.findAll()
        );
    }
}
