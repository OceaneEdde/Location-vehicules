package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("MOTORCYCLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorCycle extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private Integer cylindree;
    private String typeMoto;

    public MotorCycle(String brand,
                      String model,
                      String color,
                      FuelType fuelType,
                      Double dailyRate,
                      Double mileage,
                      Boolean active,
                      Boolean parkRemove,
                      String requiredPermit,
                      Integer cylindree,
                      String typeMoto) {

        super(brand, model, color, fuelType, dailyRate, mileage, active, parkRemove, requiredPermit);

        this.fuelType = fuelType;
        this.cylindree = cylindree;
        this.typeMoto = typeMoto;
    }
}
