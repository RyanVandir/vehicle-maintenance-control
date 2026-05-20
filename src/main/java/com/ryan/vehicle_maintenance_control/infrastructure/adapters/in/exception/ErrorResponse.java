package com.ryan.vehicle_maintenance_control.infrastructure.adapters.in.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer statusCode;
}