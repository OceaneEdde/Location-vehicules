package com.accenture.applicationlocationvehicule.controller.impl;

import com.accenture.applicationlocationvehicule.controller.AdministratorApi;
import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.service.AdministratorService;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final PasswordEncoder passwordEncoder;

        @Override
    public ResponseEntity<List<AdministratorResponseDto>> getAdministrators() {
        return ResponseEntity.ok(administratorService.findAllAdministrators());
    }

    @Override
    public ResponseEntity<AdministratorResponseDto> getAdministratorById(int id) {
        return ResponseEntity.ok(administratorService.findAdministratorById(id));
    }

    @PreAuthorize("hasRole('USER')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteAdministrator(int id) {
        administratorService.deleteAdministrator(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<AdministratorResponseDto> patchAdministrator(int id, AdministratorRequestDto requestDto) {
        AdministratorResponseDto responseDto = administratorService.updateAdministratorPartially(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
