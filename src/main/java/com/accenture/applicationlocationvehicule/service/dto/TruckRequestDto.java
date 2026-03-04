package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TruckRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_TRUCK_BRAND)
        String brand,

        @NotBlank(message = Messages.MESSAGES_ERROR_TRUCK_MODEL)
        String model,

        @NotBlank(message = Messages.MESSAGES_ERROR_TRUCK_COLOR)
        String color,

        @NotNull(message = Messages.MESSAGES_ERROR_TRUCK_FUELTYPE)
        FuelType fuelType,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_DAILYRATE_NULL)
        Double dailyRate,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_MILEAGE_NULL)
        Double mileage,

        @NotNull(message = Messages.MESSAGES_ERROR_TRUCK_ACTIVE)
        Boolean active,

        @NotNull(message = Messages.MESSAGES_ERROR_TRUCK_PARKREMOVE)
        Boolean parkRemove,

        Licenses licenses,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_NBPLACES)
        Integer nbPlaces,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_LOADMAX)
        Double loadMax,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_CAPACITY)
        Double capacity,

        @Positive(message = Messages.MESSAGES_ERROR_TRUCK_PTAC)
        Double ptac,

        @NotBlank(message = Messages.MESSAGES_ERROR_TRUCK_TRANSMISSION)
        Transmission transmission,

        @NotNull(message = Messages.MESSAGES_ERROR_TRUCK_CONDITIONINGAIR)
        Boolean conditioningAir,

        @NotBlank(message = Messages.MESSAGES_ERROR_TRUCK_TYPES)
        Types types
) {}
