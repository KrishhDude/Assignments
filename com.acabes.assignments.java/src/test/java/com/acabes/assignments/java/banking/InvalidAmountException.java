package com.acabes.assignments.java.banking;

public class InvalidAmountException extends Exception{
    int errorCode = 101;
    String category = "Invalid Amount Entered";
    String message = "Enter a valid amount to complete the transaction";
    public InvalidAmountException(int errorCode, String category, String message){
        this.errorCode = errorCode;
        this.category = category;
        this.message = message;
    }
}
