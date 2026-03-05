package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;

public record CarResponseDto(
        int id,
        String brand,
        String model,
        String color,
        FuelType fuelType,
        Double dailyRate,
        Double mileage,
        Boolean active,
        Boolean parkRemove,
        Licenses licenses) {

}

