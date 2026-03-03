package com.accenture.applicationlocationvehicule.service;


import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;

import java.util.List;

public interface MotorCycleService {

    MotorCycleResponseDto addMotorCycle(MotorCycleRequestDto dto);

    List<MotorCycleResponseDto> findAllMotorCycles();

    MotorCycleResponseDto findMotorCycleById(int idMotorCycle);

    void deleteMotorCycle(int idMotorCycle);

    MotorCycleResponseDto updateMotorCycle(int idMotorCycle, MotorCycleRequestDto dto);

    MotorCycleResponseDto updateMotorCyclePartially(int idMotorCycle, MotorCycleRequestDto dto);

}
