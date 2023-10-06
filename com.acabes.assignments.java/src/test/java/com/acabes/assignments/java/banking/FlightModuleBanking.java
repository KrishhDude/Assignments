package com.acabes.assignments.java.banking;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.Scanner;

class FlightModuleBanking {
    SavingAccount savingAccount = new SavingAccount();
    CheckingAccount checkingAccount = new CheckingAccount();

    void selectAccountType(int numOfSeats, double price, boolean isCancellation) {

        Scanner sc = new Scanner(System.in);
        int choice;
        double transactionAmount = numOfSeats * price;

        while(true){
            System.out.println("\n\nPlease select an account type:");
            System.out.println("""
                            1. Savings Account
                            2. Checking Account
                            """);

            choice = sc.nextInt();
            if (choice == 1) {
                if(isCancellation) {
                    savingAccount.deposit(transactionAmount);
                } else {
                    try {
                        if (transactionAmount < 1)
                            throw new InvalidAmountException(101, "Invalid Amount Entered", "Enter a valid amount to complete the transaction");
                        savingAccount.withdraw(transactionAmount);
                    } catch (InvalidAmountException e) {
                        System.out.println(e.message);
                    } catch (InsufficientFundException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

            } else if (choice == 2) {
                if(isCancellation) {
                    checkingAccount.deposit(transactionAmount);
                } else {
                    try{
                        if(transactionAmount<1)
                            throw new InvalidAmountException(101,"Invalid Amount Entered","Enter a valid amount to complete the transaction");
                        checkingAccount.withdraw(transactionAmount);
                    }catch (InvalidAmountException e){
                        System.out.println(e.message);
                    }
                }
                break;

            } else {
                System.out.println("plis pick 1 or 2");
            }
        }
    }
}
