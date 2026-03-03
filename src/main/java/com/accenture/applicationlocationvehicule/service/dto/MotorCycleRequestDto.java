package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
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

        @NotNull(message = "motorcycle.fuelType.null")
        FuelType fuelType,

        @Positive(message = "motorcycle.dailyRate.invalid")
        Double dailyRate,

        @Positive(message = "motorcycle.mileage.invalid")
        Double mileage,

        @NotNull(message = "motorcycle.active.null")
        Boolean active,

        @NotNull(message = "motorcycle.parkRemove.null")
        Boolean parkRemove,

        Licences licences,

        @Positive(message = "motorcycle.nbCylindree.invalid")
        Integer nbCylindree,

        @Positive(message = "motorcycle.cylindree.invalid")
        Integer cylindree,

        @Positive(message = "motorcycle.weight.invalid")
        Double weight,

        @Positive(message = "motorcycle.powerKw.invalid")
        Double powerKw,

        @Positive(message = "motorcycle.saddleHeight.invalid")
        Double saddleHeight,

        @NotBlank(message = "motorcycle.transmission.null")
        Transmission transmission,

        @NotBlank(message = "motorcycle.types.null")
        Types types
) {}
