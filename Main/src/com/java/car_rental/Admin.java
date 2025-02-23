package com.java.car_rental;
import java.util.Scanner;
import java.util.ArrayList;

import static com.java.car_rental.Car.carIdCounter;

public class Admin {
    public static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addCar() {
        int yearOfMan = 0;
        double fuelLevel = 0;
        double rentalRate = 0;
        String rentalStatus;
        boolean validInput = false;
        boolean rented = true;
        System.out.println("Enter car make: ");
        String make = scanner.next();
        System.out.println("Enter car model: ");
        String model = scanner.next();
        System.out.println("Enter car color: ");
        String color = scanner.next();
        while (!validInput) {
            try {
                System.out.println("Enter car year of manufacture: ");
                yearOfMan = Integer.parseInt(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        System.out.println("Enter car features: ");
        String features = scanner.next();
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter car fuel level: ");
                fuelLevel = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter car rental rate per day: ");
                rentalRate = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        do {
            System.out.println("Rented or Available? ");
            rentalStatus = scanner.next();
            if (rentalStatus.equalsIgnoreCase("rented")) {
                rented = false;
            } else if (rentalStatus.equalsIgnoreCase("available")) {
                rented = false;
            } else {
                System.out.println("_________________________________");
                System.out.println("Invalid answer. Please try again.");
            }
        } while (rented);

        Vehicle car = new Car(carIdCounter, make, model, color, yearOfMan, features, fuelLevel, rentalRate, rentalStatus);
        vehicles.add(car);
        System.out.println("\nVehicle added successfully!");

        do {
            System.out.println("Do you want to add another car?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                addCar();
                break;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("_________________________________");
                System.out.println("Invalid answer. Please try again.");
            }
        } while (true);
    }

    public static void editCar() {
        boolean rented = true;
        boolean validInput = false;
        int yearOfMan = 0;
        double fuelLevel = 0;
        double rentalRate = 0;
        System.out.println("CARS LIST");
        System.out.println("ID  " + "Make   " + "Model   " + "Color   " + "Year    " + "Features   " + "Fuel Level   " + "Rental Rate   " + "Rental Status   ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleId + "    " + v.make + "       " + v.model + "       " + v.color + "    " + v.yearOfMan + "    " + v.features + "    " + v.fuelLevel + "     " + v.rentalRate + "    " + v.rentalStatus + "\n");
        }
        System.out.println("Which car do you want to edit?");
        int carNo = scanner.nextInt();
        carNo = carNo - 1;
        System.out.println("Enter car ID: ");
        int vehicleID = scanner.nextInt();
        System.out.println("Enter car make: ");
        String make = scanner.next();
        System.out.println("Enter car model: ");
        String model = scanner.next();
        System.out.println("Enter car color: ");
        String color = scanner.next();
        while (!validInput) {
            try {
                System.out.println("Enter car year of manufacture: ");
                yearOfMan = Integer.parseInt(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        System.out.println("Enter car features: ");
        String features = scanner.next();
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter car fuel level: ");
                fuelLevel = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter car rental rate per day: ");
                rentalRate = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        String rentalStatus;
        do {
            System.out.println("Rented or Available? ");
            rentalStatus = scanner.next();
            if (rentalStatus.equalsIgnoreCase("rented")) {
                rented = false;
            } else if (rentalStatus.equalsIgnoreCase("available")) {
                rented = false;
            } else {
                System.out.println("_________________________________");
                System.out.println("Invalid answer. Please try again.");
            }
        } while (rented);

        Vehicle car = new Car(vehicleID, make, model, color, yearOfMan, features, fuelLevel, rentalRate, rentalStatus);
        vehicles.set(carNo, car);

        do {
            System.out.println("Do you want to edit information of another car?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
                editCar();
                break;
            } else if (answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("_________________________________");
                System.out.println("Invalid answer. Please try again.");
            }
        } while (true);
    }

    public static void removeCar() {
        boolean validInput = false;
        int carNo = 0;
        System.out.println("CARS LIST");
        System.out.println("ID  " + "Make   " + "Model   " + "Color   " + "Year    " + "Features   " + "Fuel Level   " + "Rental Rate   " + "Rental Status   ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleId + "    " + v.make + "       " + v.model + "       " + v.color + "    " + v.yearOfMan + "    " + v.features + "    " + v.fuelLevel + "     " + v.rentalRate + "    " + v.rentalStatus + "\n");
        }
        while (!validInput) {
            try {
                System.out.println("Which car do you want to remove?");
                carNo = Integer.parseInt(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        carNo = carNo - 1;
        vehicles.remove(carNo);
        System.out.println("\nVehicle removed successfully!");

        do {
            System.out.println("Do you want to remove another car?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
                removeCar();
                break;
            } else if (answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("_________________________________");
                System.out.println("Invalid answer. Please try again.");
            }
        } while (true);
    }

    public static void afterLogin() {
        System.out.println("1) Add new car\n2) Update car information\n3) Remove car\n4) Logout\nChoose option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addCar();
                afterLogin();
                break;
            case 2:
                editCar();
                afterLogin();
                break;
            case 3:
                removeCar();
                afterLogin();
                break;
            case 4:
                System.out.println("_________________________________");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println("_________________________________");
        }
    }

    public static void loginUser() {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            System.out.println("__________________________");
            System.out.println("Login successful. Welcome!");
            afterLogin();
        } else {
            System.out.println("Username or password is incorrect. Please try again.");
            loginUser();
        }
    }
}