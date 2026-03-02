package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;

import java.util.List;

public interface MotorCycleService {

    MotorCycleResponseDto addMotorCycle(MotorCycleRequestDto dto);

    List<MotorCycleResponseDto> findAllMotorCycles();

    MotorCycleResponseDto findMotorCycleById(int id);

    void deleteMotorCycle(int id);

    MotorCycleResponseDto updateMotorCycle(int id, MotorCycleRequestDto dto);

    MotorCycleResponseDto updateMotorCyclePartially(int id, MotorCycleRequestDto dto);

}
