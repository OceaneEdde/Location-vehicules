package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.FuelType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MotorCycleRequestDto(

        @NotBlank(message = "motorcycle.brand.null")
        String brand,

        @NotBlank(message = "motorcycle.model.null")
        String model,

        @NotBlank(message = "motorcycle.color.null")
        String color,

        @NotNull(message = "motorcycle.fueltype.null")
        FuelType fuelType,

        @NotNull(message = "motorcycle.dailyrate.null")
        @Positive(message = "motorcycle.dailyrate.min")
        Double dailyRate,

        @NotNull(message = "motorcycle.mileage.null")
        @Positive(message = "motorcycle.mileage.min")
        Double mileage,

        @NotNull(message = "motorcycle.active.null")
        Boolean active,

        @NotNull(message = "motorcycle.parkremove.null")
        Boolean parkRemove,

        @NotBlank(message = "motorcycle.requiredpermit.null")
        String requiredPermit,

        @NotNull(message = "motorcycle.cylindree.null")
        Integer cylindree,

        @NotBlank(message = "motorcycle.typemoto.null")
        String typeMoto
) {

}
