package com.accenture.applicationlocationvehicule.mapper;


import com.accenture.applicationlocationvehicule.model.MotorHome;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

    @Mapper(componentModel = "spring")
    public interface MotorHomeMapper {

        @Mapping(target = "id", ignore = true)
        MotorHome toMotorHome(MotorHomeRequestDto dto);
        MotorHomeResponseDto toMotorHomeResponseDto(MotorHome motorHome);
    }

