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
    public ResponseEntity<TruckResponseDto> getTruckById(int idTruck) {
        return ResponseEntity.ok(truckService.findTruckById(idTruck));
    }

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

    @Override
    public ResponseEntity<Void> deleteTruck(int idTruck) {
        truckService.deleteTruck(idTruck);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<TruckResponseDto> putTruck(int idTruck, TruckRequestDto requestDto) {
        TruckResponseDto responseDto = truckService.updateTruck(idTruck, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<TruckResponseDto> patchTruck(int idTruck, TruckRequestDto requestDto) {
        TruckResponseDto responseDto = truckService.updateTruckPartially(idTruck, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

