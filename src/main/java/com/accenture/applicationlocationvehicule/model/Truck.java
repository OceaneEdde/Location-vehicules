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
public class Truck extends Vehicle {

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int nbPlaces;
    private double loadMax;
    private double capacity;
    private double ptac;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Boolean conditioningAir;

    @Enumerated(EnumType.STRING)
    private Types types;

    public Truck(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences, FuelType fuelType, int nbPlaces, double loadMax, double capacity, double ptac, Transmission transmission, Boolean conditioningAir, Types types) {
        super(brand, model, color, dailyRate, mileage, active, parkRemove, licences);
        this.fuelType = fuelType;
        this.nbPlaces = nbPlaces;
        this.loadMax = loadMax;
        this.capacity = capacity;
        this.ptac = ptac;
        this.transmission = transmission;
        this.conditioningAir = conditioningAir;
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Truck{");
        sb.append(", fuelType=").append(fuelType);
        sb.append(", nbPlaces=").append(nbPlaces);
        sb.append(", loadMax=").append(loadMax);
        sb.append(", capacity=").append(capacity);
        sb.append(", ptac=").append(ptac);
        sb.append(", transmission='").append(transmission).append('\'');
        sb.append(", conditioningAir=").append(conditioningAir);
        sb.append(", types='").append(types).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
