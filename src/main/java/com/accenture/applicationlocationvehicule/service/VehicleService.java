package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.VehicleException;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;

import java.util.List;

public interface VehicleService {

    VehicleResponseDto addVehicle(VehicleRequestDto dto) throws VehicleException;
    List<VehicleResponseDto> findAllVehicles();
    VehicleResponseDto findById(int id);
    void deleteVehicle(int id) throws VehicleException;
    VehicleResponseDto updateVehicle(int idVehicle, VehicleRequestDto requestDto);
    VehicleResponseDto updateVehiclePartially(int idVehicle, VehicleRequestDto requestDto);
}
