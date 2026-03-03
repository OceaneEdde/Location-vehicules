package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CarRequestDto(

        @NotBlank(message = "car.brand.null")
        String brand,

        @NotBlank(message = "car.model.null")
        String model,

        @NotBlank(message = "car.color.null")
        String color,

        @NotNull(message = "car.fuelType.null")
        FuelType fuelType,

        @Positive(message = "car.dailyRate.invalid")
        Double dailyRate,

        @Positive(message = "car.mileage.invalid")
        Double mileage,

        @NotNull(message = "car.active.null")
        Boolean active,

        @NotNull(message = "car.parkRemove.null")
        Boolean parkRemove,

        Licences licences,

        @Positive(message = "car.nbPlaces.invalid")
        Integer nbPlaces,

        @Positive(message = "car.nbDoors.invalid")
        Integer nbDoors,

        @NotNull(message = "car.conditioningAir.null")
        Boolean conditioningAir,

        @NotBlank(message = "car.transmission.null")
        Transmission transmission,

        @NotBlank(message = "car.types.null")
        Types types
) {}
