package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;

public record MotorHomeResponseDto(
        int id,
        String brand,
        String model,
        String color,
        FuelType fuelType,
        Double dailyRate,
        Double mileage,
        Boolean active,
        Boolean parkRemove,
        String requiredPermit,
        int nbPlaces,
        double ptac,
        double height,
        Boolean kitchen,
        int nbBed,
        Boolean bedLinen,
        Boolean fridge,
        Boolean shower,
        String typeMotorHome
) {}
