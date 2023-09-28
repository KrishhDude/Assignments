package com.acabes.assignments.java.customexception;

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        System.out.println("Enter an integer: ");
        try {
            number = sc.nextInt();
            if(number<0){
                throw new NegativeValueException("Negative numbers not allowed");
            }
        } catch (Exception e){
            System.out.println("Negative value expression occurred");
        }
    }
}
