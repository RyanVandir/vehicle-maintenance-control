package com.ryan.vehicle_maintenance_control.infrastructure.adapters.in.exception;

import com.ryan.vehicle_maintenance_control.domain.exception.DatabaseException;
import com.ryan.vehicle_maintenance_control.domain.exception.InvalidVehicleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidVehicleException.class
    })
    public ErrorResponse handleInvalidVehicleException(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            DatabaseException.class
    })
    public ErrorResponse handlerDatabaseException(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
    }
}
