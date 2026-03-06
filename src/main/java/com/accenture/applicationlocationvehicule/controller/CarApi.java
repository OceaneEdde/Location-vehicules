package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
public interface CarApi {

    @GetMapping
    ResponseEntity<List<CarResponseDto>> getCars();

    @GetMapping("/{id}")
    ResponseEntity<CarResponseDto> getCarById(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<Void> addCar(@RequestBody CarRequestDto dto) throws CarException;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    ResponseEntity<CarResponseDto> patchCar(@PathVariable int id, @RequestBody CarRequestDto dto);
}
