package com.acabes.assignments.java.flightbooking;

public class FlightNotFoundException extends Exception {
    String message = "The flight doesnt exist";

    public FlightNotFoundException(String str) {
        this.message = str;
    }
}
