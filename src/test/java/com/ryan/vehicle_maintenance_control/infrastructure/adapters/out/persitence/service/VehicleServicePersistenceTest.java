package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.service;

import com.ryan.vehicle_maintenance_control.application.mapper.VehicleMapper;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.VehicleEntity;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;

class VehicleServicePersistenceTest {
    private final VehicleRepository vehicleRepository = Mockito.mock(VehicleRepository.class);
    private final VehicleMapper mapper = Mockito.mock(VehicleMapper.class);
    VehicleServicePersistence vehicleServicePersistence = new VehicleServicePersistence(vehicleRepository, mapper);

    private VehicleEntity vehicleEntity;
    private VehicleModel vehicleModel;

    @BeforeEach
    void setUp() {
        vehicleModel = new VehicleModel("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);

        vehicleEntity = new VehicleEntity("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);
    }

    @Test
    void save() {
        when(mapper.toModel(vehicleEntity)).thenReturn(vehicleModel);
        when(vehicleRepository.save(mapper.toEntity(vehicleModel)))
                .thenReturn(vehicleEntity);

        VehicleModel vehicleModel1 = vehicleServicePersistence.save(vehicleModel);
        Assertions.assertNotNull(vehicleModel1);
        Assertions.assertEquals(vehicleModel, vehicleModel1);
    }

    @Test
    void findAll() {
        when(mapper.toModels(List.of(vehicleEntity))).thenReturn(List.of(vehicleModel));
        when(vehicleRepository.findAll())
                .thenReturn(List.of(vehicleEntity));

        List<VehicleModel> vehicleModels = vehicleServicePersistence.findAll();
        Assertions.assertNotNull(vehicleModels);
        Assertions.assertEquals(vehicleModels.size(), 1);
    }
}