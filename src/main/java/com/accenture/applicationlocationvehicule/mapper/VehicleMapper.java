package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Vehicle;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;

public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequestDto dto);

    VehicleResponseDto toVehicleResponseDto(Vehicle saved);
}
