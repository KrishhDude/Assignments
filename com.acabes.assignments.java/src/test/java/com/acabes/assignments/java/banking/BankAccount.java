package com.acabes.assignments.java.banking;

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
