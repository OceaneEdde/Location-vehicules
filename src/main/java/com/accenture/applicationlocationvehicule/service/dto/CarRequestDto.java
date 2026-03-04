package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CarRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_CAR_BRAND)
        String brand,

        @NotBlank(message = Messages.MESSAGES_ERROR_CAR_MODEL)
        String model,

        @NotBlank(message = Messages.MESSAGES_ERROR_CAR_COLOR)
        String color,

        @NotNull(message = Messages.MESSAGES_ERROR_CAR_FUELTYPE)
        FuelType fuelType,

        @Positive(message = Messages.MESSAGES_ERROR_CAR_DAILYRATE_NULL)
        Double dailyRate,

        @Positive(message = Messages.MESSAGES_ERROR_CAR_MILEAGE_NULL)
        Double mileage,

        @NotNull(message = Messages.MESSAGES_ERROR_CAR_ACTIVE)
        Boolean active,

        @NotNull(message = Messages.MESSAGES_ERROR_CAR_PARKREMOVE)
        Boolean parkRemove,

        Licenses licenses,

        @Positive(message = Messages.MESSAGES_ERROR_CAR_NBPLACES)
        Integer nbPlaces,

        @Positive(message = Messages.MESSAGES_ERROR_CAR_NBDOORS)
        Integer nbDoors,

        @NotNull(message = Messages.MESSAGES_ERROR_CAR_CONDITIONINGAIR)
        Boolean conditioningAir,

        @NotBlank(message = Messages.MESSAGES_ERROR_CAR_TRANSMISSION)
        Transmission transmission,

        @NotBlank(message = Messages.MESSAGES_ERROR_CAR_TYPES)
        Types types
) {}
