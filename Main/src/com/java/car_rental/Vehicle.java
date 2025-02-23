package com.java.car_rental;

public class Vehicle {
    public int vehicleId;
    public String make; //toyota
    public String model;
    public String color;
    public int yearOfMan;
    public String features;
    public double fuelLevel;
    public double rentalRate;
    public String rentalStatus; // available or rented

    public Vehicle() {
    }

    public Vehicle(String make, String model, String color, int yearOfMan,
                   String features, double fuelLevel, double rentalRate, String rentalStatus) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.yearOfMan = yearOfMan;
        this.features = features;
        this.fuelLevel = fuelLevel;
        this.rentalRate = rentalRate;
        if (rentalStatus.equalsIgnoreCase("rented")) {
            this.rentalStatus = "Rented";
        } else {
            this.rentalStatus = "Available";
        }
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYearOfMan(int yearOfMan) {
        this.yearOfMan = yearOfMan;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String displayInfo(){
        return vehicleId + "," + make + "," + model + "," + color + "," + yearOfMan + "," + features + "," + fuelLevel + "," + rentalRate + "," + rentalStatus+ "\n";
    }
}

