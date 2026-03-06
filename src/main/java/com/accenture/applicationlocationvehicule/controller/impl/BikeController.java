package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.BikeApi;
import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.service.BikeService;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
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
public class BikeController implements BikeApi {

    private final BikeService bikeService;

    @Override
    public ResponseEntity<List<BikeResponseDto>> getBikes() {
        return ResponseEntity.ok(bikeService.findAllBikes());
    }

    @Override
    public ResponseEntity<BikeResponseDto> getBikeById(int id) {
        return ResponseEntity.ok(bikeService.findBikeById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> addBike(@Valid BikeRequestDto requestDto) throws BikeException {
        BikeResponseDto responseDto = bikeService.addBike(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteBike(int id) {
        bikeService.deleteBike(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<BikeResponseDto> patchBike(int id, BikeRequestDto requestDto) {
        BikeResponseDto responseDto = bikeService.updateBikePartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

