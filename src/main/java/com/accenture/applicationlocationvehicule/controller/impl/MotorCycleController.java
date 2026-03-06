package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.MotorCycleApi;
import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.service.MotorCycleService;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;
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
public class MotorCycleController implements MotorCycleApi {

    private final MotorCycleService motorCycleService;

    @Override
    public ResponseEntity<List<MotorCycleResponseDto>> getMotorCycles() {
        return ResponseEntity.ok(motorCycleService.findAllMotorCycles());
    }

    @Override
    public ResponseEntity<MotorCycleResponseDto> getMotorCycleById(int id) {
        return ResponseEntity.ok(motorCycleService.findMotorCycleById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> addMotorCycle(@Valid MotorCycleRequestDto requestDto) throws MotorCycleException {
        MotorCycleResponseDto responseDto = motorCycleService.addMotorCycle(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteMotorCycle(int id) {
        motorCycleService.deleteMotorCycle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<MotorCycleResponseDto> patchMotorCycle(int id, MotorCycleRequestDto requestDto) {
        MotorCycleResponseDto responseDto = motorCycleService.updateMotorCyclePartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
