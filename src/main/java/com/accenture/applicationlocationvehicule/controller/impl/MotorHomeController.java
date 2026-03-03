package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.MotorHomeApi;
import com.accenture.applicationlocationvehicule.exception.MotorHomeException;
import com.accenture.applicationlocationvehicule.service.MotorHomeService;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeResponseDto;
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
public class MotorHomeController implements MotorHomeApi {

    private final MotorHomeService motorHomeService;

    @Override
    public ResponseEntity<List<MotorHomeResponseDto>> getMotorHomes() {
        return ResponseEntity.ok(motorHomeService.findAllMotorHomes());
    }

    @Override
    public ResponseEntity<MotorHomeResponseDto> getMotorHomeById(int idMotorHome) {
        return ResponseEntity.ok(motorHomeService.findMotorHomeById(idMotorHome));
    }

    @Override
    public ResponseEntity<Void> addMotorHome(@Valid MotorHomeRequestDto requestDto) throws MotorHomeException {
        MotorHomeResponseDto responseDto = motorHomeService.addMotorHome(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteMotorHome(int idMotorHome) {
        motorHomeService.deleteMotorHome(idMotorHome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<MotorHomeResponseDto> putMotorHome(int idMotorHome, MotorHomeRequestDto requestDto) {
        MotorHomeResponseDto responseDto = motorHomeService.updateMotorHome(idMotorHome, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<MotorHomeResponseDto> patchMotorHome(int idMotorHome, MotorHomeRequestDto requestDto) {
        MotorHomeResponseDto responseDto = motorHomeService.updateMotorHomePartially(idMotorHome, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

