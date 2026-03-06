package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;

public record AdministratorRequestDto(
        @NotBlank(message = Messages.MESSAGES_ERROR_ADMINISTRATOR_FIRSTNAME)
        String firstname,

        @NotBlank(message = Messages.MESSAGES_ERROR_ADMINISTRATOR_LASTNAME)
        String lastname,

        @NotBlank(message = Messages.MESSAGES_ERROR_ADMINISTRATOR_EMAIL)
        String email,

        @NotBlank(message = Messages.MESSAGES_ERROR_ADMINISTRATOR_PASSWORD)
        String password,

        @NotBlank(message = Messages. MESSAGES_ERROR_ADMINISTRATOR_FUNCTION)
        String function

) {}



