package com.accenture.applicationlocationvehicule.controller.impl;


import com.accenture.applicationlocationvehicule.controller.CarApi;
import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.service.CarService;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;

    @Override
    public ResponseEntity<List<CarResponseDto>> getCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @Override
    public ResponseEntity<CarResponseDto> getCarById(int idCar) {
        return ResponseEntity.ok(carService.findCarById(idCar));
    }

    @Override
    public ResponseEntity<Void> addCar(@Valid CarRequestDto requestDto) throws CarException {
        CarResponseDto responseDto = carService.addCar(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteCar(int idCar) {
        carService.deleteCar(idCar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<CarResponseDto> putCar(int idCar, CarRequestDto requestDto) {
        CarResponseDto responseDto = carService.updateCar(idCar, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<CarResponseDto> patchCar(int idCar, CarRequestDto requestDto) {
        CarResponseDto responseDto = carService.updateCarPartially(idCar, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

