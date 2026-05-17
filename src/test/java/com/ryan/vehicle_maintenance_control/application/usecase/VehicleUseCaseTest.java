package com.ryan.vehicle_maintenance_control.application.usecase;

import com.ryan.vehicle_maintenance_control.application.ports.out.VehicleRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class VehicleUseCaseTest {

    private final VehicleRepositoryPort vehicleRepositoryPort = Mockito.mock(VehicleRepositoryPort.class);
    VehicleUseCase vehicleUseCase = new VehicleUseCase(vehicleRepositoryPort);

    private VehicleModel vehicleModel;

    @BeforeEach
    void setUp() {
        vehicleModel = new VehicleModel("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);
    }

    @Test
    void created() {
        when(vehicleRepositoryPort.save(vehicleModel)).thenReturn(vehicleModel);
        vehicleUseCase.created(vehicleModel);
    }

    @Test
    void findAll() {
        when(vehicleRepositoryPort.findAll()).thenReturn(List.of(vehicleModel));
        List<VehicleModel> vehicleModels = vehicleUseCase.findAll();
        assertNotNull(vehicleModels);
        assertEquals(vehicleModels.size(), 1);
    }
}