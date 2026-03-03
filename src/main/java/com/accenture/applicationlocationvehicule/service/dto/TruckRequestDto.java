package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TruckRequestDto(

        @NotBlank(message = "truck.brand.null")
        String brand,

        @NotBlank(message = "truck.model.null")
        String model,

        @NotBlank(message = "truck.color.null")
        String color,

        @NotNull(message = "truck.fuelType.null")
        FuelType fuelType,

        @Positive(message = "truck.dailyRate.invalid")
        Double dailyRate,

        @Positive(message = "truck.mileage.invalid")
        Double mileage,

        @NotNull(message = "truck.active.null")
        Boolean active,

        @NotNull(message = "truck.parkRemove.null")
        Boolean parkRemove,

        Licences licences,

        @Positive(message = "truck.nbPlaces.invalid")
        Integer nbPlaces,

        @Positive(message = "truck.loadMax.invalid")
        Double loadMax,

        @Positive(message = "truck.capacity.invalid")
        Double capacity,

        @Positive(message = "truck.ptac.invalid")
        Double ptac,

        @NotBlank(message = "truck.transmission.null")
        Transmission transmission,

        @NotNull(message = "truck.conditioningAir.null")
        Boolean conditioningAir,

        @NotBlank(message = "truck.types.null")
        Types types
) {}
