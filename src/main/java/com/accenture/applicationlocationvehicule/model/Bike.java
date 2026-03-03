package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bike extends Vehicle{

    private Double weight;
    private String frameSize;
    private Boolean electric;
    private double capacityBattery;
    private double autonomy;
    private Boolean discBrake;
    private Types types;


    public Bike(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences, Double weight, String frameSize, Boolean electric, double capacityBattery, double autonomy, Boolean discBrake, Types types) {
        super(brand, model, color, dailyRate, mileage, active, parkRemove, licences);
        this.weight = weight;
        this.frameSize = frameSize;
        this.electric = electric;
        this.capacityBattery = capacityBattery;
        this.autonomy = autonomy;
        this.discBrake = discBrake;
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bike{");
        sb.append(", weight=").append(weight);
        sb.append(", frameSize='").append(frameSize).append('\'');
        sb.append(", electric=").append(electric);
        sb.append(", capacityBattery=").append(capacityBattery);
        sb.append(", autonomy=").append(autonomy);
        sb.append(", discBrake=").append(discBrake);
        sb.append(", types='").append(types).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
