package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.Licences;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    @Enumerated(EnumType.STRING)
    private Licences licences;

    public Vehicle(String brand, String model, String color, Double dailyRate, Double mileage, Boolean active, Boolean parkRemove, Licences licences) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.dailyRate = dailyRate;
        this.mileage = mileage;
        this.active = active;
        this.parkRemove = parkRemove;
        this.licences = licences;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vehicle{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", dailyRate=").append(dailyRate);
        sb.append(", mileage=").append(mileage);
        sb.append(", active=").append(active);
        sb.append(", parkRemove=").append(parkRemove);
        sb.append(", Licences='").append(licences).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
