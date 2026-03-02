package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    Car toCar(CarRequestDto dto);

    CarResponseDto toCarResponseDto(Car car);
}

