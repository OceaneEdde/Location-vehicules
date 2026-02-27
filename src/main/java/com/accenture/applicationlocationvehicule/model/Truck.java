package com.accenture.applicationlocationvehicule.model;

public class Truck extends Vehicle {
    int id;
    int nbPlaces;
    double loadMax;
    double capacity;
    double ptac;
    String typeTruck;

    public Truck(int nbPlaces, double loadMax, double capacity, double ptac, String typeTruck) {
        this.nbPlaces = nbPlaces;
        this.loadMax = loadMax;
        this.capacity = capacity;
        this.ptac = ptac;
        this.typeTruck = typeTruck;
    }
}
