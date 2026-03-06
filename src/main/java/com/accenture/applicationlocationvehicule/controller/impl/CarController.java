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
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<CarResponseDto> getCarById(int id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteCar(int id) {
        carService.deleteCar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<CarResponseDto> patchCar(int id, CarRequestDto requestDto) {
        CarResponseDto responseDto = carService.updateCarPartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

