package com.accenture.applicationlocationvehicule.controller;
import com.accenture.applicationlocationvehicule.exception.MotorHomeException;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/MotorHomes")
public interface MotorHomeApi {

    @GetMapping
    ResponseEntity<List<MotorHomeResponseDto>> getMotorHomes();

    @GetMapping("/{id}")
    ResponseEntity<MotorHomeResponseDto> getMotorHomeById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addMotorHome(@RequestBody MotorHomeRequestDto dto) throws MotorHomeException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMotorHome(@PathVariable int id);

    @PutMapping("/{id}")
    ResponseEntity<MotorHomeResponseDto> putMotorHome(@PathVariable int id, @RequestBody MotorHomeRequestDto dto);

    @PatchMapping("/{id}")
    ResponseEntity<MotorHomeResponseDto> patchMotorHome(@PathVariable int id, @RequestBody MotorHomeRequestDto dto);
}
