package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;

public record MotorCycleResponseDto(
        Integer id,
        String brand,
        String model,
        String color,
        FuelType fuelType,
        Double dailyRate,
        Double mileage,
        Boolean active,
        Boolean parkRemove,
        String requiredPermit,
        Integer nbCylindree,
        Integer cylindree,
        Double weight,
        Double powerKw,
        Double saddleHeight,
        String transmissionType,
        String typeMoto
) {}
