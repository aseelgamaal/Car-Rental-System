package com.java.car_rental;

import java.io.IOException;
import java.math.BigInteger;

public abstract class User {
    private static int idCounter = 1;
    String name;
    String userName;
    String emailAddress;
    String password;
    protected BigInteger nationalId;
    protected BigInteger phoneNo;
    protected String address;

    public User() {
    }
    public User(String name, String userName, String address, String password, String emailAddress, BigInteger nationalId, BigInteger phoneNo) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.password = password;
        this.emailAddress = emailAddress;
        this.nationalId = nationalId;
        this.phoneNo = phoneNo;
    }

    public void registration(){}

    public static int getIdCounter() {
        return idCounter;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
}