package com.ryan.vehicle_maintenance_control.application.usecase;

import com.ryan.vehicle_maintenance_control.application.ports.out.VehicleRepositoryPort;
import com.ryan.vehicle_maintenance_control.domain.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleUseCaseTest {

    @Mock
    private VehicleRepositoryPort vehicleRepositoryPort;

    @InjectMocks
    private VehicleUseCase vehicleUseCase;

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Vehicle("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);
    }

    @Test
    void created() {
        when(vehicleRepositoryPort.save(vehicle)).thenReturn(vehicle);
        Vehicle result = vehicleUseCase.created(vehicle);

        assertNotNull(result);
        assertEquals(vehicle, result);

    }

    @Test
    void findAll() {
        when(vehicleRepositoryPort.findAll()).thenReturn(List.of(vehicle));
        List<Vehicle> result = vehicleUseCase.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}