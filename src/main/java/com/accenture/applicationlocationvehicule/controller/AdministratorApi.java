package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
public interface AdministratorApi {
    @GetMapping
    ResponseEntity<List<AdministratorResponseDto>> getAdministrators();

    @GetMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> getAdministratorById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addAdministrator(@RequestBody AdministratorRequestDto dto) throws AdministratorException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAdministrator(@PathVariable int id);

    @PatchMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> patchAdministrator(@PathVariable int id, @RequestBody AdministratorRequestDto dto);
}
