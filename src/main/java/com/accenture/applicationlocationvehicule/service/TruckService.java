package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.TruckException;
import com.accenture.applicationlocationvehicule.service.dto.TruckRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.TruckResponseDto;

import java.util.List;

public interface TruckService {
    TruckResponseDto addTruck(TruckRequestDto dto) throws TruckException;

    List<TruckResponseDto> findAllTrucks();

    TruckResponseDto findTruckById(int id);

    void deleteTruck(int id);

    TruckResponseDto updateTruck(int id, TruckRequestDto dto);

    TruckResponseDto updateTruckPartially(int idTruck, TruckRequestDto requestDto);
}

