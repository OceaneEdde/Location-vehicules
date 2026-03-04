package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Car extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int nbPlaces;
    private int nbDoors;
    private Boolean conditioningAir;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private Types types;

    @Enumerated(EnumType.STRING)
    private Licenses licenses;


}
