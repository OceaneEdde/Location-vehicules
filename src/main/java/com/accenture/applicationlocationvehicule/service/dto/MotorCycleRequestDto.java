package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MotorCycleRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORCYCLE_BRAND)
        String brand,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORCYCLE_MODEL)
        String model,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORCYCLE_COLOR)
        String color,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORCYCLE_FUELTYPE)
        FuelType fuelType,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_DAILYRATE_NULL)
        Double dailyRate,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_MILEAGE_NULL)
        Double mileage,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORCYCLE_ACTIVE)
        Boolean active,

        @NotNull(message = Messages.MESSAGES_ERROR_MOTORCYCLE_PARKREMOVE)
        Boolean parkRemove,

        Licenses licenses,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_NBCYLINDREE)
        Integer nbCylindree,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_CYLINDREE)
        Integer cylindree,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_WEIGHT)
        Double weight,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_POWERKW )
        Double powerKw,

        @Positive(message = Messages.MESSAGES_ERROR_MOTORCYCLE_SADDLEHEIGHT)
        Double saddleHeight,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORCYCLE_TRANSMISSION)
        Transmission transmission,

        @NotBlank(message = Messages.MESSAGES_ERROR_MOTORCYCLE_TYPES)
        Types types
) {}
