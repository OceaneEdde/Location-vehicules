package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.TruckApi;
import com.accenture.applicationlocationvehicule.exception.TruckException;
import com.accenture.applicationlocationvehicule.service.TruckService;
import com.accenture.applicationlocationvehicule.service.dto.TruckRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.TruckResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class TruckController implements TruckApi {

    private final TruckService truckService;

    @Override
    public ResponseEntity<List<TruckResponseDto>> getTrucks() {
        return ResponseEntity.ok(truckService.findAllTrucks());
    }

    @Override
    public ResponseEntity<TruckResponseDto> getTruckById(int id) {
        return ResponseEntity.ok(truckService.findTruckById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> addTruck(@Valid TruckRequestDto requestDto) throws TruckException {
        TruckResponseDto responseDto = truckService.addTruck(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteTruck(int id) {
        truckService.deleteTruck(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<TruckResponseDto> patchTruck(int id, TruckRequestDto requestDto) {
        TruckResponseDto responseDto = truckService.updateTruckPartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

