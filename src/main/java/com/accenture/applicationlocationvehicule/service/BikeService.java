package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
import java.util.List;

public interface BikeService {
    BikeResponseDto addBike(BikeRequestDto dto) throws BikeException;

    List<BikeResponseDto> findAllBikes();

    BikeResponseDto findBikeById(int id);

    void deleteBike(int id);

    BikeResponseDto updateBike(int id, BikeRequestDto dto);

    BikeResponseDto updateBikePartially(int idBike, BikeRequestDto requestDto);
}

