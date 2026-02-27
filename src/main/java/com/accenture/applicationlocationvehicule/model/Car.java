package com.accenture.applicationlocationvehicule.model;

public class Car extends Vehicle {
    int id;
    int nbPlaces;
    int nbDoors;
    Boolean ConditioningAir;
    String typeCar;

    public Car(int nbPlaces, int nbDoors, Boolean conditioningAir, String typeCar) {
        this.nbPlaces = nbPlaces;
        this.nbDoors = nbDoors;
        ConditioningAir = conditioningAir;
        this.typeCar = typeCar;
    }
}
