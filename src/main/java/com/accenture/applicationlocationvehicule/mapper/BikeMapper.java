package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Bike;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    @Mapping(target = "id", ignore = true)
    Bike toBike(BikeRequestDto dto);
    BikeResponseDto toBikeResponseDto(Bike bike);
}


