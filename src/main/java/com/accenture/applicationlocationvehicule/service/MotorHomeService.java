package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.MotorHomeException;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeResponseDto;

import java.util.List;

public interface MotorHomeService {
    MotorHomeResponseDto addMotorHome(MotorHomeRequestDto dto) throws MotorHomeException;

    List<MotorHomeResponseDto> findAllMotorHomes();

    MotorHomeResponseDto findMotorHomeById(int id);

    void deleteMotorHome(int id);

    MotorHomeResponseDto updateMotorHomePartially(int id, MotorHomeRequestDto requestDto);
}

