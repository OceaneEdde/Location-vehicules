package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Truck extends Vehicle {
    int id;
    int nbPlaces;
    double loadMax;
    double capacity;
    double ptac;
    String typeTruck;

    public Truck(String brand, String model, String color, Enum fuelType, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, String requiredPermit, int nbPlaces, double loadMax, double capacity, double ptac, String typeTruck) {
        super(brand, model, color, fuelType, dailyRate, mileage, active, parkRemove, requiredPermit);
        this.nbPlaces = nbPlaces;
        this.loadMax = loadMax;
        this.capacity = capacity;
        this.ptac = ptac;
        this.typeTruck = typeTruck;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Truck{");
        sb.append("id=").append(id);
        sb.append(", nbPlaces=").append(nbPlaces);
        sb.append(", loadMax=").append(loadMax);
        sb.append(", capacity=").append(capacity);
        sb.append(", ptac=").append(ptac);
        sb.append(", typeTruck='").append(typeTruck).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
