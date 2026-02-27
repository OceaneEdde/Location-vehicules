package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private String color;
    private Enum fuelType;
    private Double dailyRate;
    private Double mileage;
    private Boolean active;
    private Boolean parkRemove;
    private String requiredPermit;

    public Vehicle(String brand, String model, String color, Enum fuelType, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, String requiredPermit) {

    }
}
