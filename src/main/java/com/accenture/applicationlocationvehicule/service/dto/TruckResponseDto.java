package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;

public record TruckResponseDto(
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
        double loadMax,
        double capacity,
        double ptac,
        String transmissionType,
        Boolean conditioningAir,
        String typeTruck
) {}

