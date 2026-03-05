package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
public interface ClientApi {
    @GetMapping
    ResponseEntity<List<ClientResponseDto>> getClients();

    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> getClientById(@PathVariable int id);

    @PostMapping
    ResponseEntity<Void> addClient(@RequestBody ClientRequestDto dto) throws ClientException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable int id);

    @PatchMapping("/{id}")
    ResponseEntity<ClientResponseDto> patchClient(@PathVariable int id, @RequestBody ClientRequestDto dto);
}
