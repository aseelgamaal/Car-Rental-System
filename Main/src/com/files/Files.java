package com.files;

import com.java.car_rental.*;

import java.io.*;
import java.math.BigInteger;

import static com.java.car_rental.Admin.vehicles;
import static com.java.car_rental.CarAgency.reservationHistories;
import static com.java.car_rental.Customer.customerList;

public interface Files {
    public static void Read(String path) {
        try {
            FileReader read = new FileReader(path);
            BufferedReader reader = new BufferedReader(read);
            String line;
            while (((line = reader.readLine()) != null)) {
                // Process each line and create a vehicle object
                String[] values = line.split(","); // Assuming comma-separated values
                switch (path) {
                    case "C:/Users/aseel/IdeaProjects/Main/car.txt" ->
                            vehicles.add(new Car(Integer.parseInt(values[0]), values[1], values[2], values[3], Integer.parseInt(values[4]), values[5], Double.parseDouble(values[6]), Double.parseDouble(values[7]), values[8]));
                    case "C:/Users/aseel/IdeaProjects/Main/customer.txt" ->
                            customerList.add(new Customer(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], values[5], new BigInteger(values[6]), new BigInteger(values[7])));
                    case "C:/Users/aseel/IdeaProjects/Main/reservation.txt" ->
                            reservationHistories.add(new Reservation(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6], Double.parseDouble(values[7])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(String path) {
        try {
            FileWriter writer = new FileWriter(path, false);
            switch (path) {
                case "C:/Users/aseel/IdeaProjects/Main/car.txt" -> {
                    for (Vehicle v : vehicles) {
                        writer.write(v.displayInfo());
                    }
                }
                case "C:/Users/aseel/IdeaProjects/Main/customer.txt" -> {
                    for (Customer c : customerList) {
                        writer.write(c.display());
                    }
                }
                case "C:/Users/aseel/IdeaProjects/Main/reservation.txt" -> {
                    for (Reservation r : reservationHistories) {
                        writer.write(r.display());
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}