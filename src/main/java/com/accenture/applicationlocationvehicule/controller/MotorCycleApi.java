package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/motorCycle")
public interface MotorCycleApi {
    @GetMapping
    ResponseEntity<List<MotorCycleResponseDto>> getMotorCycles();

    @GetMapping("/{id}")
    ResponseEntity<MotorCycleResponseDto> getMotorCycleById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addMotorCycle(@RequestBody MotorCycleRequestDto dto) throws MotorCycleException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMotorCycle(@PathVariable int id);

    @PatchMapping("/{id}")
    ResponseEntity<MotorCycleResponseDto> patchMotorCycle(@PathVariable int id, @RequestBody MotorCycleRequestDto dto);
}
