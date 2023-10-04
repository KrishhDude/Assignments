package com.acabes.assignments.java.collections.testslists;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestList {

    static void printList() {
    }

    public static void main(String[] args) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        String nameToRemove;

        List<String> myList = new ArrayList<>(10);

        System.out.println("Enter 5 names: ");
        for (int i = 0; i < 5; i++) {
            try {
                String userInput = sc.nextLine();
                if (userInput.matches("^[a-zA-Z ]+$")) {
                    myList.add(userInput);
                } else {
                    i--;        /* To preserve a skipped iteration */
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter a valid name, as a string");
            }
        }

        System.out.println(myList);

        System.out.println("Enter name to remove:");
        nameToRemove = sc.next();
        while (true) {
            try {
                if (myList.contains(nameToRemove)) {
                    myList.remove(nameToRemove);
                    System.out.println(myList);
                    break;
                } else {
                    throw new InvalidInputException("Invalid input");
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, the entered string does not exist within the list");
            }
        }
    }
}
