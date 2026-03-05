package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;
import com.accenture.applicationlocationvehicule.utils.Address;

import java.time.LocalDate;
import java.util.List;

public record ClientResponseDto(
        int id,
        String firstname,
        String lastname,
        String email,
        Address address,
        LocalDate birthdate,
        LocalDate registrationdate,
        List<LicensesListe> licensesListeList) {
}