package com.accenture.applicationlocationvehicule.model;

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

    public MotorHome(int nbPlaces, double ptac, double height, Boolean kitchen, Boolean bedLinen, Boolean fridge, Boolean shower, String typeMotorHome) {
        this.nbPlaces = nbPlaces;
        this.ptac = ptac;
        this.height = height;
        this.kitchen = kitchen;
        this.bedLinen = bedLinen;
        this.fridge = fridge;
        this.shower = shower;
        this.typeMotorHome = typeMotorHome;
    }
}
