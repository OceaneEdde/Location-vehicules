package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MotorHomeRequestDto(

        @NotBlank(message = "motorhome.brand.null")
        String brand,

        @NotBlank(message = "motorhome.model.null")
        String model,

        @NotBlank(message = "motorhome.color.null")
        String color,

        @NotNull(message = "motorhome.fuelType.null")
        FuelType fuelType,

        @Positive(message = "motorhome.dailyRate.invalid")
        Double dailyRate,

        @Positive(message = "motorhome.mileage.invalid")
        Double mileage,

        @NotNull(message = "motorhome.active.null")
        Boolean active,

        @NotNull(message = "motorhome.parkRemove.null")
        Boolean parkRemove,

        Licences licences,

        @Positive(message = "motorhome.nbPlaces.invalid")
        Integer nbPlaces,

        @Positive(message = "motorhome.ptac.invalid")
        Double ptac,

        @Positive(message = "motorhome.height.invalid")
        Double height,

        @NotNull(message = "motorhome.kitchen.null")
        Boolean kitchen,

        @Positive(message = "motorhome.nbBed.invalid")
        Integer nbBed,

        @NotNull(message = "motorhome.bedLinen.null")
        Boolean bedLinen,

        @NotNull(message = "motorhome.fridge.null")
        Boolean fridge,

        @NotNull(message = "motorhome.shower.null")
        Boolean shower,

        @NotBlank(message = "motorhome.types.null")
        Types types,

        @NotBlank(message = "motorhome.transmission.null")
        Transmission transmission

) {}
