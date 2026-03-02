package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Bike;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.model.Vehicle;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface BikeMapper {

    @Mapper(componentModel = "spring")
    public interface BikeMapper {


        @Mapping(target="id", ignore = true)
        <BikeRequestDto>
        Bike toBike(BikeRequestDto dto);

        BikeResponseDto toBikeResponseDto(Bike bike);
    }
}


