package com.acabes.assignments.java.dividebyzero;

import java.util.Scanner;

public class DividingByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number1;
        int number2;
        int result;
        System.out.println("Enter two numbers: ");
        number1 = sc.nextInt();
        number2 = sc.nextInt();

        try{
            result = number1/number2;
            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e){
            System.out.println(e + "Recheck input numbers");

        }
    }
}
