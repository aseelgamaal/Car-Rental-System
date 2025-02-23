package com.java.car_rental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static com.java.car_rental.Customer.reservationHistory;
import static com.java.car_rental.Customer.reservedCar;

public class Reservation {
    Scanner input = new Scanner(System.in);
    private static int reservationIdCounter = 1;
    public int reservationId;
    int customerId;
    int carId; //hsaweha b id bta3 el car lma customer y3ml book
    String pickupDate;
    String returnDate;
    public double totalPrice;
    String pickupLocation;
    String returnLocation;
    private String Status; //(pending,confirmed,cancelled)
    private LocalDate realReturnedDate;
    private String realReturnedDateFormatted;

    public Reservation() {
    }
    // car id , customer id
    public Reservation(int reservationId, int carId, int customerId, String pickupDate, String returnDate, String pickupLocation, String returnLocation, Double totalPrice) {
        this.reservationId = reservationIdCounter++;
        this.carId=carId;
        this.customerId=customerId;
        this.pickupDate = pickupDate;
        this.returnDate = pickupDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.totalPrice = totalPrice;
    }

    public void reservationIdHandling() {
        this.reservationId = reservationIdCounter++;
    }

    public LocalDate getRealReturnedDate() {
        return realReturnedDate;
    }

    public void setRealReturnedDate() {
        this.realReturnedDate = LocalDate.now();
    }

    public String getRealReturnedDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        setRealReturnedDate();
        setRealReturnedDateFormatted((getRealReturnedDate().format(formatter)));
        return realReturnedDateFormatted;
    }

    public void setRealReturnedDateFormatted(String realReturnedDateFormatted) {
        this.realReturnedDateFormatted = realReturnedDateFormatted;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    } //5letha kda 34an h set feha total price lma a7sbo b2a

    //     function to return duration
    public long getDuration(String pickupDate, String returnDate) { //reservationHistory.pickupDate and returnDate ely customer hyd5lhum
        String pattern = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        // Parse strings to LocalDate objects
        LocalDate startDate = LocalDate.parse(pickupDate, formatter);
        LocalDate endDate = LocalDate.parse(returnDate, formatter);
//            return duration; //I will return it in a duration variable of datatype long
        return ChronoUnit.DAYS.between(startDate, endDate);
    } //I will access this method in calculate total price by reservationHistory  field in customer class

    public class InvalidDate extends Exception {
    }

    public String enterDate() {
        Scanner input = new Scanner(System.in);
        int day, month, year;
        boolean valid = false;
        String date = null;
//        boolean flag=false;
        do {
            try {
                date = input.next();
                if (date.length() == 10) {
                    String[] dateParts = date.split("-");
                    day = Integer.parseInt(dateParts[0]);
                    month = Integer.parseInt(dateParts[1]);
                    year = Integer.parseInt(dateParts[2]);
                    try {
                        if (month <= 0 || month > 12) {
                            throw new InvalidDate();
                        }
                        if (year < 2023) {
                            throw new Exception();
                        } else {
                            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                                {
                                    if (day >= 1 && day <= 31)
                                        valid = true;
                                    else
                                        throw new InvalidDate();
                                }
                            } else if (month == 2) {
                                if (day >= 1 && day <= 28)
                                    valid = true;
                                else
                                    throw new InvalidDate();
                            } else {
                                if (month == 4 || month == 6 || month == 9 || month == 11) {
                                    {
                                        if (day >= 1 && day <= 30)
                                            valid = true;
                                        else
                                            throw new InvalidDate();
                                    }
                                }
                            }
                        }
                    } catch (
                            InvalidDate I) { //handling exception in case day>max days for each month days or <0 also if month>12 or <0
                        System.out.println("Invalid date. Please try again");
                        continue;
                    }
                } else {
                    System.out.println("Invalid date format. Please enter it in (dd-mm-yyyy) format"); //if user didn't enter the date in the true format i will enable him to enter it again
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year");
                continue;
            }
        } while (!valid);
        return date;
    }

    public String enterDate2() {
        Scanner input = new Scanner(System.in);
        int day = 0, month = 0, year;
        boolean valid = false;
        String date = null;
        do {
            try {
                date = input.next();
                if (date.length() == 10) {
                    String[] dateParts = date.split("-");
                    day = Integer.parseInt(dateParts[0]);
                    month = Integer.parseInt(dateParts[1]);
                    year = Integer.parseInt(dateParts[2]);
                    try {
                        if (month <= 0 || month > 12) {
                            throw new InvalidDate();
                        }
                        if (year < 2023) {
                            throw new Exception();
                        } else {
                            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                                {
                                    if (day >= 1 && day <= 31)
                                        valid = true;
                                    else
                                        throw new InvalidDate();
                                }
                            } else if (month == 2) {
                                if (day >= 1 && day <= 28)
                                    valid = true;
                                else
                                    throw new InvalidDate();
                            } else {
                                if (month == 4 || month == 6 || month == 9 || month == 11) {
                                    {
                                        if (day >= 1 && day <= 30)
                                            valid = true;
                                        else
                                            throw new InvalidDate();
                                    }
                                }
                            }
                        }
                    } catch (
                            InvalidDate I) { //handling exception in case day>max days for each month days or <0 also if month>12 or <0
                        System.out.println("Invalid Date. Please try again");
                        continue;
                    }
                } else {
                    System.out.println("Invalid Date format, please enter it in (dd-mm-yyyy) format"); //if user didn't enter the date in the true format i will enable him to enter it again
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid Year, please enter a valid year");
                continue;
            }
        } while (!valid);

        if (day == 15 || day == 30) {
            System.out.println("you have 25% off !!, enjoy your ride ");
            totalPrice *= 0.25;
        } else if (day == 31 && month == 12) {
            System.out.println("Happy New Year!!! you have 50% off");
            totalPrice *= 0.5;
        }
        return date;
    }

    public void viewReservation() {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Pickup Date: " + pickupDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Return Location: " + returnLocation);
        System.out.println("Total Price " + totalPrice);
        System.out.println("____________________________________");
        System.out.println("Continue?");
        String cont = input.next();
    }

    public void cancelReservation() {
        boolean validReservationId = false;
        boolean validCancelledCarId = false;
        Car cancelledCar = null;
        Reservation cancelledReservation = null;
        System.out.println("Enter the Car you want to cancel it's reservation ID:");
        do {
            int cId = input.nextInt();
            for (Vehicle car : Admin.vehicles) {
                if (cId == car.vehicleId) {
                    validCancelledCarId = true;
//                    cancelledCar = car;
//                    Customer.reservedCar = new Car(car.vehicleId, car.make, car.model, car.color, car.yearOfMan, car.features, car.fuelLevel, car.rentalRate, car.rentalStatus);
                    cancelledCar=reservedCar;
                    break;
                }
            }
            if (validCancelledCarId && cancelledCar != null) {
                break;
            } else {
                System.out.println("Invalid Car ID, please enter it correctly:");
                continue;
            }
        } while (!validCancelledCarId);

        System.out.println("Enter your reservation ID:");
        do {
            int reservationID = input.nextInt();
            for (Reservation reservation : CarAgency.reservationHistories) {
                if (reservationID ==( reservation.reservationId+2)) {
                    validReservationId = true;
                    cancelledReservation = reservation;
                    cancelledReservation = new Reservation (reservation.reservationId, reservation.carId, reservation.customerId, reservation.pickupDate, reservation.returnDate,  reservation.pickupLocation,  reservation.returnLocation, reservation.totalPrice);
                    break;
                }
            }
            if (validReservationId && cancelledReservation != null) { //y3ne la2yt el id w 3mlt save l object reservation ely la2yto fe arrayoflist
                break;
            } else {
                System.out.println("Invalid Reservation ID, please enter it correctly:");
                continue;
            }
        } while (!validCancelledCarId);

        if (validCancelledCarId && validReservationId) {
            cancelledCar.rentalStatus = "Available";
            cancelledReservation.setStatus("Cancelled");
            System.out.println("You have successfully cancelled your reservation!");
        }
    }
    public void offers() {
        System.out.println("Do you know that we have offers !!! \nin days 15 & 30 every month we have an offer 25% off and in new year we have an offer 50% !!");
    }
    //    public void modifyReservation(){
//        System.out.println("a.Pickup Date");
//        System.out.println("b.return Date");
//        System.out.println("c.Pickup Location");
//        System.out.println("a.Return Date");
//        System.out.println("a.Pickup Date");
//        System.out.println("Enter what you want to modify about your reservation:")
//    }
    public String display(){
        return reservationId + "," + carId + "," + customerId + "," + pickupDate + "," + returnDate + "," + pickupLocation + "," + returnLocation + "," + totalPrice + "\n";
    }
}