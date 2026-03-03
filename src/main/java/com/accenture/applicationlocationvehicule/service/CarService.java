package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto addCar(CarRequestDto dto) throws CarException;

    List<CarResponseDto> findAllCars();

    CarResponseDto findCarById(int id);

    void deleteCar(int id);

    CarResponseDto updateCar(int id, CarRequestDto dto);

    CarResponseDto updateCarPartially(int idCar, CarRequestDto requestDto);
}

