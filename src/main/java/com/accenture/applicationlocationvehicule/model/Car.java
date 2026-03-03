package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    public Car(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences, FuelType fuelType, int nbPlaces, int nbDoors, Boolean conditioningAir, Transmission transmission, Types types) {
        super(brand, model, color, dailyRate, mileage, active, parkRemove, licences);
        this.fuelType = fuelType;
        this.nbPlaces = nbPlaces;
        this.nbDoors = nbDoors;
        this.conditioningAir = conditioningAir;
        this.transmission = transmission;
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append(", fuelType=").append(fuelType);
        sb.append(", nbPlaces=").append(nbPlaces);
        sb.append(", nbDoors=").append(nbDoors);
        sb.append(", conditioningAir=").append(conditioningAir);
        sb.append(", transmission='").append(transmission).append('\'');
        sb.append(", types='").append(types).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
