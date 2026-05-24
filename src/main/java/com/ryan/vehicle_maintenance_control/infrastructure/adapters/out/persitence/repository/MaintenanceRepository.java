package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.repository;

import com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Integer> {
}
