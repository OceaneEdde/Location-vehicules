package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CAR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int nbPlaces;
    private int nbDoors;
    private Boolean conditioningAir;
    private String typeCar;

    public Car(String brand,
               String model,
               String color,
               FuelType fuelType,
               Double dailyRate,
               Double mileage,
               Boolean active,
               Boolean parkRemove,
               String requiredPermit,
               int nbDoors,
               int nbPlaces,
               Boolean conditioningAir,
               String typeCar) {

        super(brand, model, color, fuelType, dailyRate, mileage, active, parkRemove, requiredPermit);

        this.fuelType = fuelType;
        this.nbDoors = nbDoors;
        this.nbPlaces = nbPlaces;
        this.conditioningAir = conditioningAir;
        this.typeCar = typeCar;
    }
}
