package com.acabes.assignments.java.banking;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.Scanner;


abstract class BankAccount{
    public long accountNumber = 101010;
    public String accountHolder="John Doe";
    public double balance=100000;

    void deposit(double depositAmount){
        try{
            if(depositAmount<1){
                throw new InvalidAmountException(101,"Invalid Amount Entered","Enter a valid amount to complete the transaction");
            }
            else{
                balance += depositAmount;
                System.out.println("\nAmount deposited: " + depositAmount);
                System.out.println("Curr avl balance: " + balance);
            }
        } catch (InvalidAmountException e) {
            System.out.println(e.errorCode + ':' + e.message);
        }
    };
    abstract boolean withdraw(double withdrawalAmount) throws InsufficientFundException;
    double viewbalance(){
        return balance;
    }
}

class FlightModuleBanking {
    SavingAccount savingAccount = new SavingAccount();
    CheckingAccount checkingAccount = new CheckingAccount();

    void selectAccountType(int numOfSeats, double price, boolean isCancellation) throws InvalidInputException {

        Scanner sc = new Scanner(System.in);
        int choice;
        double transactionAmount = numOfSeats * price;

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
        } else {
            throw new InvalidInputException("Invalid input. Input should be either 1 or 2!");
        }
    }
}

class SavingAccount extends BankAccount{
    void applyInterest(float interestRate){
        double interestAmount = (balance * interestRate * 1)/100;
        balance += interestAmount;
        System.out.println("\nInterest Applied: " + interestAmount);
        System.out.println("Curr avl balance after interest: " + balance);
    }
    boolean withdraw(double withdrawalAmount) throws InsufficientFundException {

        try {
            if (withdrawalAmount > balance) {
                System.out.println("Insufficient balance to complete the transaction\n" +
                        "Current available balance: " + balance);
                throw new InsufficientFundException(100, "Insufficient Balance", "Ensure you have enough balance in your account");
            }
        } catch (InsufficientFundException e){
            System.out.println(e.message);
            return false;
        }
        balance -= withdrawalAmount;
        System.out.println("Amount withdrawn: " + withdrawalAmount +
                            "\nCurrent available balance: " + balance);
        return false;
    }
}

class CheckingAccount extends BankAccount{
    double overdraftFee = 0;
    boolean withdraw(double withdrawalAmount) {
        if(withdrawalAmount>balance){
            overdraftFee = balance - withdrawalAmount;
            balance -= withdrawalAmount;
            System.out.println("Amount withdrawn: " + withdrawalAmount);
            System.out.println("Overdraft: " + overdraftFee );
        }
        else{
            balance -= withdrawalAmount;
            System.out.println("Amount withdrawn: " + withdrawalAmount +
                    "\nCurrent available balance: " + balance);
        }
        return false;
    }
}

public class BankingMain {

    private static FlightModuleBanking flightbank = new FlightModuleBanking();

    public static void flightRedirect(int numOfSeats, double price, boolean isCancellation) throws InvalidInputException {
        flightbank.selectAccountType(numOfSeats, price, isCancellation);
    }


    public static void main(String[] args) throws InsufficientFundException {
        Scanner sc = new Scanner(System.in);
        SavingAccount saving = new SavingAccount();
        CheckingAccount checking = new CheckingAccount();

        System.out.println("Hello! and welcome to Model Bank");

        boolean typeSelect = true;
        while(typeSelect){

            System.out.println("\n\nPlease select your account type:\n" +
                                "1: Savings Account \n2: Checking Account\n3: Exit System");
            int accountType = sc.nextInt();

            if(accountType == 1){
                boolean flag = true;
                while(flag){
                    System.out.println("\n\n\nWhat would you like to do?\n" +
                                        "1. View Current Balance\n2. Deposit\n3. Withdraw\n4. Add interest rate\n5. Exit\n");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println(saving.viewbalance());
                            break;
                        case 2:

                            System.out.println("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            saving.deposit(depositAmount);
                            break;

                        case 3:
                            System.out.println("Enter amount to withdraw: ");
                            try{
                                double withdrawalAmount = sc.nextDouble();
                                if(withdrawalAmount<1)
                                    throw new InvalidAmountException(101,"Invalid Amount Entered","Enter a valid amount to complete the transaction");
                                saving.withdraw(withdrawalAmount);
                            }catch (InvalidAmountException e){
                                System.out.println(e.message);
                            }
                            break;

                        case 4:
                            System.out.println("Enter your interest rate");
                            float interestRate = sc.nextFloat();
                            saving.applyInterest(interestRate);
                            break;
                        case 5:
                            flag = false;
                            break;
                    }
                }
            }
            if(accountType == 2){
                boolean flag = true;
                while(flag){
                    System.out.println("\n\n\nWhat would you like to do?\n" +
                            "1. View Current Balance\n2. Deposit\n3. Withdraw\n4. Exit\n");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println(checking.viewbalance());
                            break;
                        case 2:
                            System.out.println("Enter amount to deposit: ");
                            try{
                                double depositAmount = sc.nextDouble();
                                if(depositAmount<1)
                                    throw new InvalidAmountException(101,"Invalid Amount Entered","Enter a valid amount to complete the transaction");
                                checking.deposit(depositAmount);
                                break;
                            } catch (InvalidAmountException e){
                                System.out.println(e.message);
                            }
                            break;
                        case 3:
                            try{
                                double withdrawalAmount = sc.nextDouble();
                                if(withdrawalAmount<1)
                                    throw new InvalidAmountException(101,"Invalid Amount Entered","Enter a valid amount to complete the transaction");
                                checking.withdraw(withdrawalAmount);
                            }catch (InvalidAmountException e){
                                System.out.println(e.message);
                            }
                            break;

                        case 4:
                            flag = false;
                            break;
                    }
                }
            }
            if(accountType==3){
                typeSelect=false;
            }
        }
    }
}
