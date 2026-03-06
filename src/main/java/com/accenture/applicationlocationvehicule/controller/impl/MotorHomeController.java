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
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<MotorHomeResponseDto> getMotorHomeById(int id) {
        return ResponseEntity.ok(motorHomeService.findMotorHomeById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteMotorHome(int id) {
        motorHomeService.deleteMotorHome(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<MotorHomeResponseDto> patchMotorHome(int id, MotorHomeRequestDto requestDto) {
        MotorHomeResponseDto responseDto = motorHomeService.updateMotorHomePartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

