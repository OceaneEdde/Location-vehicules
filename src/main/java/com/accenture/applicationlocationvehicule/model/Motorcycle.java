package com.accenture.applicationlocationvehicule.model;

public class Motorcycle extends Vehicle {
    int id;
    int nbCylinders;
    double cylinder;
    double weight;
    double powerKm;
    double heightSaddle;
    String typeMotorCycle;

    public Motorcycle(int nbCylinders, double cylinder, double weight, double powerKm, double heightSaddle, String typeMotorCycle) {
        this.nbCylinders = nbCylinders;
        this.cylinder = cylinder;
        this.weight = weight;
        this.powerKm = powerKm;
        this.heightSaddle = heightSaddle;
        this.typeMotorCycle = typeMotorCycle;
    }
}
