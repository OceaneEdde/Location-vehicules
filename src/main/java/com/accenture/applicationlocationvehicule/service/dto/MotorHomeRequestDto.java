package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MotorHomeRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORHOME_BRAND)
        String brand,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORHOME_MODEL)
        String model,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORHOME_COLOR)
        String color,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_FUELTYPE)
        FuelType fuelType,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_DAYLIRATE_NULL)
        Double dailyRate,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_MILEAGE_NULL)
        Double mileage,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_ACTIVE)
        Boolean active,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_PARKREMOVE)
        Boolean parkRemove,

        Licenses licenses,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_NBPLACES)
        Integer nbPlaces,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_PTAC)
        Double ptac,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_HEIGHT)
        Double height,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_KITCHEN)
        Boolean kitchen,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORHOME_NBBED)
        Integer nbBed,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_NBLINEN)
        Boolean bedLinen,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_FRIDGE)
        Boolean fridge,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORHOME_SHOWER)
        Boolean shower,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORHOME_TYPES)
        Types types,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORHOME_TRANSMISSION)
        Transmission transmission

) {}
