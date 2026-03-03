package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.TruckException;
import com.accenture.applicationlocationvehicule.service.dto.TruckRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.TruckResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trucks")
public interface TruckApi {

    @GetMapping
    ResponseEntity<List<TruckResponseDto>> getTrucks();

    @GetMapping("/{id}")
    ResponseEntity<TruckResponseDto> getTruckById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addTruck(@RequestBody TruckRequestDto dto) throws TruckException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTruck(@PathVariable int id);

    @PutMapping("/{id}")
    ResponseEntity<TruckResponseDto> putTruck(@PathVariable int id, @RequestBody TruckRequestDto dto);

    @PatchMapping("/{id}")
    ResponseEntity<TruckResponseDto> patchTruck(@PathVariable int id, @RequestBody TruckRequestDto dto);
}
