package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Vehicle;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target="id", ignore = true)
    Vehicle toVehicle(VehicleRequestDto dto);

    VehicleResponseDto toVehicleResponseDto(Vehicle saved);
}
