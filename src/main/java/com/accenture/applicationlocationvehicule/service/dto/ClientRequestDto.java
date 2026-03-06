package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.*;
import com.accenture.applicationlocationvehicule.model.Address;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ClientRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_FIRSTNAME)
        String firstname,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_LASTNAME)
        String lastname,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_EMAIL)
        String email,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_EMAIL_INVALID)
        String password,

        @Valid
        @NotNull(message = Messages.MESSAGES_ERROR_CLIENT_ADDRESS)
        Address address,

        @NotNull(message = Messages.MESSAGES_ERROR_CLIENT_BIRTHDATE)
        LocalDate birthdate,

        @NotNull(message = Messages.MESSAGES_ERROR_CLIENT_REGISTRATIONDATE)
        LocalDate registrationdate,

        List<LicensesListe>licensesListeList
) {}



