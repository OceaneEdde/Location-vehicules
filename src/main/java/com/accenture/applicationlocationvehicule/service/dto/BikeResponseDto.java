package com.accenture.applicationlocationvehicule.service.dto;

public record BikeResponseDto(
        int id,
        String brand,
        String model,
        String color,
        Double dailyRate,
        Double mileage,
        Boolean active,
        Boolean parkRemove,
        String requiredPermit,
        Double weight,
        String frameSize,
        Boolean electric,
        Double capacityBattery,
        Double autonomy,
        Boolean discBrake,
        String typeBike
) {}
