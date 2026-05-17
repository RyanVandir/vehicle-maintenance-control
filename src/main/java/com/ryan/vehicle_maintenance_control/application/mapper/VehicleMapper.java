package com.ryan.vehicle_maintenance_control.application.mapper;

import com.ryan.vehicle_maintenance_control.application.dto.VehicleRequestDTO;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {

    VehicleRequestDTO toRequest(VehicleModel vehicleModel);

    VehicleModel toModel(VehicleRequestDTO request);

    VehicleModel toModel(VehicleEntity vehicleEntity);

    List<VehicleRequestDTO> toRequests(List<VehicleModel> models);

    List<VehicleModel> toModels(List<VehicleEntity> entities);

    VehicleEntity toEntity(VehicleModel vehicleModel);
}
