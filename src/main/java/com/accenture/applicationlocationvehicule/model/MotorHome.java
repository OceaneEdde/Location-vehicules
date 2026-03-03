package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MotorHome extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int nbPlaces;
    private double ptac;
    private double height;
    private Boolean kitchen;
    private int nbBed;
    private Boolean bedLinen;
    private Boolean fridge;
    private Boolean shower;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private Types types;

    public MotorHome(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences, FuelType fuelType, int nbPlaces, double ptac, double height, Boolean kitchen, int nbBed, Boolean bedLinen, Boolean fridge, Boolean shower, Transmission transmission, Types types) {
        super(brand, model, color, dailyRate, mileage, active, parkRemove, licences);
        this.fuelType = fuelType;
        this.nbPlaces = nbPlaces;
        this.ptac = ptac;
        this.height = height;
        this.kitchen = kitchen;
        this.nbBed = nbBed;
        this.bedLinen = bedLinen;
        this.fridge = fridge;
        this.shower = shower;
        this.transmission = transmission;
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MotorHome{");
        sb.append("fuelType=").append(fuelType);
        sb.append(", nbPlaces=").append(nbPlaces);
        sb.append(", ptac=").append(ptac);
        sb.append(", height=").append(height);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", nbBed=").append(nbBed);
        sb.append(", bedLinen=").append(bedLinen);
        sb.append(", fridge=").append(fridge);
        sb.append(", shower=").append(shower);
        sb.append(", transmission=").append(transmission);
        sb.append(", types=").append(types);
        sb.append('}');
        return sb.toString();
    }
}
