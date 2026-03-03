package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Truck;
import com.accenture.applicationlocationvehicule.service.dto.TruckRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.TruckResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TruckMapper {

    @Mapping(target = "id", ignore = true)
    Truck toTruck(TruckRequestDto dto);
    TruckResponseDto toTruckResponseDto(Truck truck);
}
