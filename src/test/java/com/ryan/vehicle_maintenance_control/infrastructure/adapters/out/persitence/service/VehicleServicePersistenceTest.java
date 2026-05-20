package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.service;

import com.ryan.vehicle_maintenance_control.application.mapper.VehicleMapper;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.VehicleEntity;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServicePersistenceTest {
    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private VehicleMapper mapper;

    @InjectMocks
    VehicleServicePersistence vehicleServicePersistence;

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
        when(mapper.toEntity(vehicleModel))
                .thenReturn(vehicleEntity);

        when(mapper.toModel(vehicleEntity))
                .thenReturn(vehicleModel);

        when(vehicleRepository.save(vehicleEntity))
                .thenReturn(vehicleEntity);

        VehicleModel result = vehicleServicePersistence.save(vehicleModel);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(vehicleModel, result);
    }

    @Test
    void findAll() {
        when(mapper.toModels(List.of(vehicleEntity)))
                .thenReturn(List.of(vehicleModel));

        when(vehicleRepository.findAll())
                .thenReturn(List.of(vehicleEntity));

        List<VehicleModel> result = vehicleServicePersistence.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }
}