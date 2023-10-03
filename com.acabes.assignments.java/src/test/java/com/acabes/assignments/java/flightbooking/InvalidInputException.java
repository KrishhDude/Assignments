package com.acabes.assignments.java.flightbooking;

import com.acabes.assignments.java.banking.InvalidAmountException;

public class InvalidInputException extends Exception {
    String message = "Invalid input";

    public InvalidInputException(String str) {
        super();
        this.message = str;
    }
}
