package com.acabes.assignments.java.banking;

class SavingAccount extends BankAccount{
    void applyInterest(float interestRate){
        double interestAmount = (balance * interestRate * 1)/100;
        balance += interestAmount;
        System.out.println("\nInterest Applied: " + interestAmount);
        System.out.println("Curr avl balance after interest: $" + balance);
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
        System.out.println("Amount withdrawn from savings account: $" + withdrawalAmount +
                "\nCurrent available balance: $" + balance);
        return false;
    }
}
