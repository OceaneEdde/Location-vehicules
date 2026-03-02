package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Truck;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
    public interface TruckMapper {

        @Mapping(target = "id", ignore = true)
        Truck toTruck(CarRequestDto dto);
        CarResponseDto toVehicleResponseDto(Truck truck);
    }

