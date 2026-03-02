package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class MotorHome extends Vehicle {
    int id;
    int nbPlaces;
    double ptac;
    double height;
    Boolean kitchen;
    Boolean bedLinen;
    Boolean fridge;
    Boolean shower;
    String typeMotorHome;

    public MotorHome(String brand, String model, String color, Enum fuelType, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, String requiredPermit, int nbPlaces, double ptac, double height, Boolean kitchen, Boolean fridge, Boolean bedLinen, Boolean shower, String typeMotorHome) {
        super(brand, model, color, fuelType, dailyRate, mileage, active, parkRemove, requiredPermit);
        this.nbPlaces = nbPlaces;
        this.ptac = ptac;
        this.height = height;
        this.kitchen = kitchen;
        this.fridge = fridge;
        this.bedLinen = bedLinen;
        this.shower = shower;
        this.typeMotorHome = typeMotorHome;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MotorHome{");
        sb.append("id=").append(id);
        sb.append(", nbPlaces=").append(nbPlaces);
        sb.append(", ptac=").append(ptac);
        sb.append(", height=").append(height);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", bedLinen=").append(bedLinen);
        sb.append(", fridge=").append(fridge);
        sb.append(", shower=").append(shower);
        sb.append(", typeMotorHome='").append(typeMotorHome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
