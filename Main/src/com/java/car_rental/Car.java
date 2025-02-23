package com.java.car_rental;

import java.util.List;

public class Car extends Vehicle {
    static int carIdCounter = 1;

    public Car() {
    }

    public Car(int vehicleId, String make, String model, String color, int yearOfMan,
               String features, double fuelLevel, Double rentalRate,
               String rentalStatus) {
        super(make, model, color, yearOfMan, features, fuelLevel, rentalRate, rentalStatus);
        this.vehicleId = carIdCounter++;
    }

    public static void compareCars(Car car1, Car car2) {
        System.out.println("Comparison between:");
        System.out.println("Car 1: " + car1.make + " " + car1.model);
        System.out.println("Car 2: " + car2.make + " " + car2.model);

        // Compare by rental rate per day
        if (car1.rentalRate < car2.rentalRate) {
            System.out.println("Car 1 has a lower rental rate per day than Car 2.");
        } else if (car1.rentalRate > car2.rentalRate) {
            System.out.println("Car 2 has a lower rental rate per day than Car 1.");
        } else {
            System.out.println("Both cars have the same rental rate per day.");
        }

        // Compare by features
        System.out.println("Car 1 features: " + car1.features);
        System.out.println("Car 2 features: " + car2.features);

        // Compare by fuel level
        if (car1.fuelLevel < car2.fuelLevel) {
            System.out.println("Car 1 has lower fuel level than Car 2.");
        } else if (car1.fuelLevel > car2.fuelLevel) {
            System.out.println("Car 2 has lower fuel level than Car 1.");
        } else {
            System.out.println("Both cars have the same fuel level.");
        }

        //compare by car color
        System.out.println("Car 1 color: " + car1.color);
        System.out.println("Car 2 color: " + car2.color);

        if (car1.yearOfMan < car2.yearOfMan) {
            System.out.println("Car 1 has lower year of manufacture than Car 2. ");
        } else if (car1.yearOfMan > car2.yearOfMan) {
            System.out.println("Car 2 has lower year of manufacture than Car 1. ");
        } else {
            System.out.println("Both Cars have the same year of manufacture. ");
        }
    }
}
