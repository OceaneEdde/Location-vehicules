package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bikes")
public interface BikeApi {


    @GetMapping
    ResponseEntity<List<BikeResponseDto>> getBikes();

    @GetMapping("/{id}")
    ResponseEntity<BikeResponseDto> getBikeById(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<Void> addBike(@RequestBody BikeRequestDto dto) throws BikeException;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBike(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    ResponseEntity<BikeResponseDto> patchBike(@PathVariable int id, @RequestBody BikeRequestDto dto);
}
