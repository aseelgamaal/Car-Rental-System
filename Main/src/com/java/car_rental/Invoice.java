package com.java.car_rental;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private static int invoiceIdCounter = 1;
    int invoiceId;
    int customerId;
    int reservationId;
    double totalAmount;
    long rentalPeriod; //duration
    LocalDate dateOfIssue;
    String invoiceStatus;

    public static ArrayList<Invoice> invoiceList = new ArrayList<>();
//    String paymentStatus; //paid or pending "paid when returning and pending when booking"

    public Invoice(int customerId, int reservationId, double totalAmount, long rentalPeriod) {

        this.invoiceId = invoiceIdCounter++;
        this.customerId = customerId;
        this.reservationId = reservationId;
        this.totalAmount = totalAmount;
        this.rentalPeriod = rentalPeriod;
        this.dateOfIssue = LocalDate.now(); //return current date
//    this.paymentStatus=paymentStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void displayInvoice() {
        System.out.println("Thank You for renting from our App");
        System.out.println("Your Invoice Details:");
        System.out.println("Customer ID: " + customerId); //hb3t customerId ely hyd5lo
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Total Price: " + totalAmount);
        System.out.println("Rental period: " + rentalPeriod);
        System.out.println("Date of Issue: " + dateOfIssue);
        System.out.println("Invoice Status: " + invoiceStatus);
    }
}