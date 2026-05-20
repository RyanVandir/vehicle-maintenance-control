package com.ryan.vehicle_maintenance_control.domain.exception;

public class InvalidVehicleException extends RuntimeException {
    public InvalidVehicleException(String message) {
        super(message);
    }
}
