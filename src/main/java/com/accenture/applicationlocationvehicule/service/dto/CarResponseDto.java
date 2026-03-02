package com.accenture.applicationlocationvehicule.service.dto;

public record CarResponseDto(int id, String brand, String model, String color, Enum fuelType, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, String requiredPermit ) {
}
