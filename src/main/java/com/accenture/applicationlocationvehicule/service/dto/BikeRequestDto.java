package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BikeRequestDto(

        @NotBlank(message = Messages.MESSAGES_ERROR_BIKE_BRAND)
        String brand,

        @NotBlank(message = Messages.MESSAGES_ERROR_BIKE_MODEL)
        String model,

        @NotBlank(message = Messages.MESSAGES_ERROR_BIKE_COLOR)
        String color,

        @Positive(message = Messages.MESSAGES_ERROR_BIKE_DAILYRATE_MIN)
        Double dailyRate,

        @Positive(message = Messages.MESSAGES_ERROR_BIKE_MILEAGE_MIN)
        Double mileage,

        @NotNull(message = Messages.MESSAGES_ERROR_BIKE_ACTIVE)
        Boolean active,

        @NotNull(message = Messages.MESSAGES_ERROR_BIKE_PARKREMOVE)
        Boolean parkRemove,

        Licenses licenses,

        @Positive(message = Messages.MESSAGES_ERROR_BIKE_WEIGHT)
        Double weight,

        @NotBlank(message = Messages.MESSAGES_ERROR_BIKE_FRAMESIZE)
        String frameSize,

        @NotNull(message = Messages.MESSAGES_ERROR_BIKE_ELECTRIC)
        Boolean electric,

        @Positive(message = Messages.MESSAGES_ERROR_BIKE_CAPACITYBATTERY)
        Double capacityBattery,

        @Positive(message = Messages.MESSAGES_ERROR_BIKE_AUTONOMY)
        Double autonomy,

        @NotNull(message = Messages.MESSAGES_ERROR_BIKE_DISCBRAKE)
        Boolean discBrake,

        @NotBlank(message = Messages.MESSAGES_ERROR_BIKE_TYPES)
        Types types
) {

}
