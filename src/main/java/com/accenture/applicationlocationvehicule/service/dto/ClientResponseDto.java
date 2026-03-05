package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;

import java.time.LocalDateTime;

public record ClientResponseDto(
        int id,
        String firstname,
        String lastname,
        String email,
        String address,
        LocalDateTime birthdate,
        LocalDateTime inscriptiondate,
        LicensesListe licensesListe) {
}