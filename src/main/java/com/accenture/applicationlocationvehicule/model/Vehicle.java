package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;
    private String model;
    private String color;
    private Double dailyRate;
    private Double mileage;
    private Boolean active;
    private Boolean parkRemove;
    private String requiredPermit;

    public Vehicle(String brand,
                   String model,
                   String color,
                   Enum fuelType, Double dailyRate,
                   Double mileage,
                   Boolean active,
                   Boolean parkRemove,
                   String requiredPermit) {

        this.brand = brand;
        this.model = model;
        this.color = color;
        this.dailyRate = dailyRate;
        this.mileage = mileage;
        this.active = active;
        this.parkRemove = parkRemove;
        this.requiredPermit = requiredPermit;
    }
}
