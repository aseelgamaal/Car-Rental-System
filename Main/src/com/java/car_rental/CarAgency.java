package com.java.car_rental;

import java.util.ArrayList;
import java.util.Scanner;

public class CarAgency {
    private static int agencyId;
    private static String locationAddress;
    private static String locationCity;
    private static String contactEmail;
    private static String contactPhone;
    protected static double totalRevenue;
    public static ArrayList<Reservation> reservationHistories = new ArrayList<>();
    static CarAgency agency = new CarAgency(843, "Nasr City", "Abbas el akkad street", "ourcaragency1@gmail.com", "01028763946");

    public CarAgency(int agencyId, String locationAddress, String locationCity, String contactEmail, String contactPhone) {
        CarAgency.agencyId = agencyId;
        CarAgency.locationAddress = locationAddress;
        CarAgency.locationCity = locationCity;
        CarAgency.contactEmail = contactEmail;
        CarAgency.contactPhone = contactPhone;
        totalRevenue = 0.0;
    }
    public static int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        CarAgency.agencyId = agencyId;
    }

    public static String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        CarAgency.locationAddress = locationAddress;
    }

    public static String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        CarAgency.locationCity = locationCity;
    }

    public static String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        CarAgency.contactEmail = contactEmail;
    }

    public static String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        CarAgency.contactPhone = contactPhone;
    }
    public static void agencyInfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Agency ID: " + getAgencyId());
        System.out.println("Location Address: " + getLocationAddress());
        System.out.println("Location City: " + getLocationCity());
        System.out.println("Contact Email: " + getContactEmail());
        System.out.println("Contact Phone: " + getContactPhone());
        System.out.println("Continue?");
        String yes = scanner.next();
        System.out.println("_________________________________");
    }

}