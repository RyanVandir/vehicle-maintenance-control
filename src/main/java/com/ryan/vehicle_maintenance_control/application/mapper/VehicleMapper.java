package com.ryan.vehicle_maintenance_control.application.mapper;

import com.ryan.vehicle_maintenance_control.application.dto.VehicleRequestDTO;
import com.ryan.vehicle_maintenance_control.domain.model.Vehicle;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {

    VehicleRequestDTO toRequest(Vehicle vehicle);

    Vehicle toModel(VehicleRequestDTO request);

    Vehicle toModel(VehicleEntity vehicleEntity);

    List<VehicleRequestDTO> toRequests(List<Vehicle> models);

    List<Vehicle> toModels(List<VehicleEntity> entities);

    VehicleEntity toEntity(Vehicle vehicle);
}
