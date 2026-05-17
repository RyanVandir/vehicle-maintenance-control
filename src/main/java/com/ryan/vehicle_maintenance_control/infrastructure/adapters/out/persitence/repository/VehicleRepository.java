package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository;

import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
}
