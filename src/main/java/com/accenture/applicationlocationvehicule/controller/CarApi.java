package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
public interface CarApi {

    @GetMapping
    ResponseEntity<List<CarResponseDto>> getCars();

    @GetMapping("/{id}")
    ResponseEntity<CarResponseDto> getCarById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addCar(@RequestBody CarRequestDto dto) throws CarException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(@PathVariable int id);

    @PutMapping("/{id}")
    ResponseEntity<CarResponseDto> putCar(@PathVariable int id, @RequestBody CarRequestDto dto);

    @PatchMapping("/{id}")
    ResponseEntity<CarResponseDto> patchCar(@PathVariable int id, @RequestBody CarRequestDto dto);
}
