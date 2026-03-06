package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/administrators")
public interface AdministratorApi {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<AdministratorResponseDto>> getAdministrators();

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> getAdministratorById(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<Void> addAdministrator(@RequestBody AdministratorRequestDto dto) throws AdministratorException;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAdministrator(@PathVariable int id);

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> patchAdministrator(@PathVariable int id, @RequestBody AdministratorRequestDto dto);
}
