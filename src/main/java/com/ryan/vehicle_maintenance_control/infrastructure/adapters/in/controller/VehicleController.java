package com.ryan.vehicle_maintenance_control.infrastructure.adapters.in.controller;

import com.ryan.vehicle_maintenance_control.application.dto.VehicleRequestDTO;
import com.ryan.vehicle_maintenance_control.application.mapper.VehicleMapper;
import com.ryan.vehicle_maintenance_control.application.ports.in.VehicleUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carros")
public class VehicleController {

    private final VehicleUseCasePort vehicleUseCasePort;
    private final VehicleMapper mapper;

    @PostMapping
    public ResponseEntity<VehicleRequestDTO> postCar(@RequestBody VehicleRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        mapper.toRequest(
                                vehicleUseCasePort.created(mapper.toModel(request)
                                )
                        )
                );
    }

    @GetMapping
    public ResponseEntity<List<VehicleRequestDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        mapper.toRequests(
                                vehicleUseCasePort.findAll()
                        )
                );
    }

}