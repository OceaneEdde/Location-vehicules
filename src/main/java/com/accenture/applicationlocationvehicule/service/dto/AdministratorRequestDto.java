package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.LicensesListe;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AdministratorRequestDto(
        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_NOTFOUND)
        int id,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_FIRSTNAME)
        String firstname,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_LASTNAME)
        String lastname,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_EMAIL)
        String email,

        @NotBlank(message = Messages.MESSAGES_ERROR_CLIENT_EMAIL_INVALID)
        String password,

        @NotBlank(message = Messages. MESSAGES_ERROR_CLIENT_ADDRESS)
        String function

) {}



