package com.acabes.assignments.java.banking;

public class InsufficientFundException extends Exception {
    int errorCode = 100;
    String category = "Insufficient Balance";
    String message = "Please ensure you have enough balance in your account to complete the transaction";
    public InsufficientFundException(int errorCode, String category, String message){
        this.errorCode = errorCode;
        this.category = category;
        this.message = message;
    }
}
