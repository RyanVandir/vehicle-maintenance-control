package com.ryan.vehicle_maintenance_control.infrastructure.adapters.in.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryan.vehicle_maintenance_control.application.dto.VehicleRequestDTO;
import com.ryan.vehicle_maintenance_control.application.mapper.VehicleMapper;
import com.ryan.vehicle_maintenance_control.application.ports.in.VehicleUseCasePort;
import com.ryan.vehicle_maintenance_control.domain.model.VehicleModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc; // Disparador de requisições HTTP simulados
    @Autowired
    private ObjectMapper objectMapper;// Converte Obj Java em String JSON

    @MockitoBean
    private VehicleUseCasePort vehicleUseCasePort;
    @MockitoBean
    private VehicleMapper mapper;

    private VehicleModel vehicleModel;
    private VehicleRequestDTO vehicleRequestDTO;

    @BeforeEach
    void setUp() {
        vehicleModel = new VehicleModel("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);
        vehicleRequestDTO = new VehicleRequestDTO("Toyota",
                "HDSVD",
                2011,
                "2.0 flex",
                144);
    }

    @Test
    void created() throws Exception {
        when(mapper.toModel(any(VehicleRequestDTO.class)))
                .thenReturn(vehicleModel);

        when(mapper.toRequest(any(VehicleModel.class)))
                .thenReturn(vehicleRequestDTO);

        when(vehicleUseCasePort.created(any(VehicleModel.class)))
                .thenReturn(vehicleModel);

        mockMvc.perform(
                        post("/api/v1/carros")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(vehicleRequestDTO)
                                )
                )
                .andExpect(status()
                        .isCreated())
                .andExpect(jsonPath("$.marca")
                        .value("Toyota"))
                .andExpect(jsonPath("$.ano")
                        .value(2011));

        verify(vehicleUseCasePort).created(any(VehicleModel.class));
    }

    @Test
    void findAll() throws Exception {
        when(vehicleUseCasePort.findAll())
                .thenReturn(List.of(vehicleModel));
        when(mapper.toRequests(anyList()))
                .thenReturn(List.of(vehicleRequestDTO));

        mockMvc.perform(
                        get("/api/v1/carros")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status()
                        .isOk())
                .andExpect(jsonPath("$[0].marca")
                        .value("Toyota"))
                .andExpect(jsonPath("$[0].ano")
                        .value(2011));;

        verify(vehicleUseCasePort).findAll();
    }
}