package com.accenture.applicationlocationvehicule.model;

public class Bike extends Vehicle{
    int id;
    Double weight;
    String frameSize;
    Boolean electric;
    double capacityBattery;
    double autonomy;
    Boolean discBrake;
    String typeBike;

    public Bike(Double weight, String frameSize, Boolean electric, double capacityBattery, double autonomy, Boolean discBrake, String typeBike) {
        this.weight = weight;
        this.frameSize = frameSize;
        this.electric = electric;
        this.capacityBattery = capacityBattery;
        this.autonomy = autonomy;
        this.discBrake = discBrake;
        this.typeBike = typeBike;
    }
}
