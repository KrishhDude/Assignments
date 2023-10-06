package com.acabes.assignments.java.banking;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.Scanner;


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
