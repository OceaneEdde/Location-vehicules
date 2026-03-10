package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;

import java.time.LocalDateTime;

public record AdministratorResponseDto(
        int id,
        String firstname,
        String lastname,
        String email,
        String function,
        String password)
{ }