package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.VehicleApi;
import com.accenture.applicationlocationvehicule.service.VehicleService;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;
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
public class VehicleController implements VehicleApi {
    private final VehicleService vehicleService;

    @Override
    public ResponseEntity<List<VehicleResponseDto>> getVehicles(){
        return ResponseEntity.ok(vehicleService.findAllVehicles());
    }

    @Override
    public ResponseEntity<VehicleResponseDto> getVehicleById(int idVehicle){
        return ResponseEntity.ok(vehicleService.findById(idVehicle));
    }



    @Override
    public ResponseEntity<Void> addVehicle(@Valid VehicleRequestDto requestDto){
        VehicleResponseDto responseDto = vehicleService.addVehicle(requestDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @Override
    public ResponseEntity<Void> deleteVehicle(int idVehicle) {
        vehicleService.deleteVehicle(idVehicle);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Override
    public ResponseEntity<VehicleResponseDto> putVehicle(int idVehicle, VehicleRequestDto requestDto) {
        VehicleResponseDto responseDto = vehicleService.updateVehicle(idVehicle, requestDto);
        return ResponseEntity.ok(responseDto);
    }


    @Override
    public ResponseEntity<VehicleResponseDto> patchVehicle(int idVehicle, VehicleRequestDto requestDto) {
        VehicleResponseDto responseDto = vehicleService.updateVehiclePartially(idVehicle, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
