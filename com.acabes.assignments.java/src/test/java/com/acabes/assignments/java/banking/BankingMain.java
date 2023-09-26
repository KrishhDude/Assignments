package com.acabes.assignments.java.banking;

import java.util.Scanner;

abstract class BankAccount{
    public long accountNumber = 101010;
    public String accountHolder="John Doe";
    public double balance=50;

    void deposit(double depositAmount){
        balance += depositAmount;
        System.out.println("\nAmount deposited: " + depositAmount);
        System.out.println("Curr avl balance: " + balance);
    };
    abstract void withdraw(double withdrawalAmount);
}

class SavingAccount extends BankAccount{
    float interestRate = 5.5f;
    void applyInterest(){
        double interestAmount = (balance * interestRate * 1)/100;
        balance += interestAmount;
        System.out.println("\nInterest Applied: " + interestAmount);
        System.out.println("Curr avl balance after interest: " + balance);
    }
    void withdraw(double withdrawalAmount) {
        if(withdrawalAmount>balance){
            System.out.println("Insufficient balance to complete the transaction\n" +
                                "Current available balance: " + balance);
        }
        else{
            balance -= withdrawalAmount;
            System.out.println("Amount withdrawn: " + withdrawalAmount +
                                "\nCurrent available balance: " + balance);
        }
    }
}

class CheckingAccount extends BankAccount{
    double overdraftFee = 0;
    void withdraw(double withdrawalAmount) {
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
    }
}

public class BankingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount saving = new SavingAccount();
        CheckingAccount checking = new CheckingAccount();

        System.out.println("Hello! and welcome to Model Bank");
        System.out.println("Please select your account type:\n" +
                            "1: Savings Account \n2: Checking Account\n");
        int accountType = sc.nextInt();
        if(accountType == 1){
            boolean flag = true;
            while(flag){
                System.out.println("\nWhat would you like to do?\n" +
                                    "1. Deposit\n2. Withdraw\n3. View current interest amount\n4. Exit\n");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        saving.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawalAmount = sc.nextDouble();
                        saving.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        saving.applyInterest();
                        break;
                    case 4:
                        flag = false;
                        break;
                }
            }
        }
    }
}
