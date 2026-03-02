package com.accenture.applicationlocationvehicule.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Bike extends Vehicle{
    int id;
    Double weight;
    String frameSize;
    Boolean electric;
    double capacityBattery;
    double autonomy;
    Boolean discBrake;
    String typeBike;

    public Bike(String brand, String model, String color, Enum fuelType, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, String requiredPermit, Double weight, String frameSize, Boolean electric, double capacityBattery, double autonomy, Boolean discBrake, String typeBike) {
        super(brand, model, color, fuelType, dailyRate, mileage, active, parkRemove, requiredPermit);
        this.weight = weight;
        this.frameSize = frameSize;
        this.electric = electric;
        this.capacityBattery = capacityBattery;
        this.autonomy = autonomy;
        this.discBrake = discBrake;
        this.typeBike = typeBike;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bike{");
        sb.append("id=").append(id);
        sb.append(", weight=").append(weight);
        sb.append(", frameSize='").append(frameSize).append('\'');
        sb.append(", electric=").append(electric);
        sb.append(", capacityBattery=").append(capacityBattery);
        sb.append(", autonomy=").append(autonomy);
        sb.append(", discBrake=").append(discBrake);
        sb.append(", typeBike='").append(typeBike).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
