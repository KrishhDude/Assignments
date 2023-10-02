package com.acabes.assignments.java.flightbooking;

import java.util.Objects;
import java.util.Scanner;

public class AdminAccess {
    private String password = "Admin@123";
    boolean adminValidation(){
        Scanner sc = new Scanner(System.in);
        String userPassword = "";

        System.out.println("Enter Password: ");
        userPassword = sc.next();
        return password.equals(userPassword);
    }
}
