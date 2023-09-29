package com.acabes.assignments.java.flightbooking;

public class FlightNotFoundException extends Exception {
    String message;

    public FlightNotFoundException(String str) {
        this.message = str;
    }
}
