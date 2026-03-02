package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.MotorCycle;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MotorCycleMapper {

        @Mapping(target = "id", ignore = true)
        MotorCycle toMotorCycle(MotorCycleRequestDto dto);

        MotorCycleResponseDto toMotorCycleResponseDto(MotorCycle motorCycle);
}

