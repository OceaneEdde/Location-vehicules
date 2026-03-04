package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Bike extends Vehicle{

    private Double weight;
    private String frameSize;
    private Boolean electric;
    private double capacityBattery;
    private double autonomy;
    private Boolean discBrake;

    @Enumerated(EnumType.STRING)
    private Types types;


}
