package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bikes")
public interface BikeApi {

    @GetMapping
    ResponseEntity<List<BikeResponseDto>> getBikes();

    @GetMapping("/{id}")
    ResponseEntity<BikeResponseDto> getBikeById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addBike(@RequestBody BikeRequestDto dto) throws BikeException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBike(@PathVariable int id);

    @PutMapping("/{id}")
    ResponseEntity<BikeResponseDto> putBike(@PathVariable int id, @RequestBody BikeRequestDto dto);

    @PatchMapping("/{id}")
    ResponseEntity<BikeResponseDto> patchBike(@PathVariable int id, @RequestBody BikeRequestDto dto);
}
