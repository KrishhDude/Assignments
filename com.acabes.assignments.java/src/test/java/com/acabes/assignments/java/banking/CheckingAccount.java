package com.acabes.assignments.java.banking;

class CheckingAccount extends BankAccount{
    double overdraftFee = 0;
    boolean withdraw(double withdrawalAmount) {
        if(withdrawalAmount>balance){
            overdraftFee = balance - withdrawalAmount;
            balance -= withdrawalAmount;
            System.out.println("Amount withdrawn from checking account: $" + withdrawalAmount);
            System.out.println("Overdraft: $" + overdraftFee );
        }
        else{
            balance -= withdrawalAmount;
            System.out.println("Amount withdrawn: $" + withdrawalAmount +
                    "\nCurrent available balance: $" + balance);
        }
        return false;
    }
}
