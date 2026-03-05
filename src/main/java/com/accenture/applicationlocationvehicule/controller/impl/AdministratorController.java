package com.accenture.applicationlocationvehicule.controller.impl;


import com.accenture.applicationlocationvehicule.controller.AdministratorApi;
import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.service.AdministratorService;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/administrators")
public class AdministratorController implements AdministratorApi {
    private final AdministratorService administratorService;


    @Override
    public ResponseEntity<List<AdministratorResponseDto>> getAdministrators() {
        return ResponseEntity.ok(administratorService.findAllAdministrators());
    }

    @Override
    public ResponseEntity<AdministratorResponseDto> getAdministratorById(int idAdministrator) {
        return ResponseEntity.ok(administratorService.findAdministratorById(idAdministrator));
    }

    @Override
    public ResponseEntity<Void> addAdministrator(@Valid AdministratorRequestDto requestDto) throws AdministratorException {
        AdministratorResponseDto responseDto = administratorService.addAdministrator(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteAdministrator(int idAdministrator) {
        administratorService.deleteAdministrator(idAdministrator);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<AdministratorResponseDto> patchAdministrator(int idAdministrator, AdministratorRequestDto requestDto) {
        AdministratorResponseDto responseDto = administratorService.updateAdministratorPartially(idAdministrator, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
