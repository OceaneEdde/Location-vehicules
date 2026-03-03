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
public class MotorCycle extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int nbCylindree;
    private Integer cylindree;
    private double weight;
    private double powerKw;
    private double saddleHeight;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private Types types;

    public MotorCycle(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences, FuelType fuelType, int nbCylindree, double weight, Integer cylindree, double powerKw, double saddleHeight, Transmission transmission, Types types) {
        super(brand, model, color, dailyRate, mileage, active, parkRemove, licences);
        this.fuelType = fuelType;
        this.nbCylindree = nbCylindree;
        this.weight = weight;
        this.cylindree = cylindree;
        this.powerKw = powerKw;
        this.saddleHeight = saddleHeight;
        this.transmission = transmission;
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MotorCycle{");
        sb.append(", fuelType=").append(fuelType);
        sb.append(", nbCylindree=").append(nbCylindree);
        sb.append(", cylindree=").append(cylindree);
        sb.append(", weight=").append(weight);
        sb.append(", powerKw=").append(powerKw);
        sb.append(", saddleHeight=").append(saddleHeight);
        sb.append(", transmission='").append(transmission).append('\'');
        sb.append(", types='").append(types).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
