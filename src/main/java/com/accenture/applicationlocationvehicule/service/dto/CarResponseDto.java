package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
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
        Licenses licenses,
        int nbPlaces,
        int nbDoors,
        Boolean conditioningAir,
        Transmission transmission,
        Types types) {

}

