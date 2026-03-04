package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
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



}
