package com.ryan.vehicle_maintenance_control.infrastructure.adapters.out.persitence.entity;

import com.ryan.vehicle_maintenance_control.domain.enums.MaintenanceCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "maintenances")
public class MaintenanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private Integer kmProximaTroca;
    private LocalDate proximaTroca;

    @ElementCollection(targetClass = MaintenanceCategory.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "maintenance_categories",
            joinColumns = @JoinColumn(name = "maintenance_id")
    )
    @Column(name = "category")
    private Set<MaintenanceCategory> categories;
}
