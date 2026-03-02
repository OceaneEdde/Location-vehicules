package com.accenture.applicationlocationvehicule.service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;


public record CarRequestDto(

    @NotBlank(message = "vehicle.brand.null")
    String brand,

    @NotBlank(message = "vehicle.model.null")
    String model,

    @NotBlank(message = "vehicle.color.null")
    String color,

    @NotNull(message = "vehicle.fuelType.null")
    Enum fuelType,

    @Positive(message = "vehicle.dailyRate.invalid")
    Double dailyRate,

    @Positive(message = "vehicle.mileage.invalid")
    Double mileage,

    @NotNull(message = "vehicle.active.null")
    Boolean active,

    @NotNull(message = "vehicle.parkRemove.null")
    Boolean parkRemove,
    String requiredPermit){
    }
