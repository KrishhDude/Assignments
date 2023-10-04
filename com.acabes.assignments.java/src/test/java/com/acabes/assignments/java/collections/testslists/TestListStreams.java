package com.acabes.assignments.java.collections.testslists;

import java.util.*;
import java.util.stream.Collectors;

public class TestListStreams {

    static boolean checkForName(List<String> list, String nameToSearch) {

        return list.stream().anyMatch(
                value -> value.contains(nameToSearch));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> myList = new ArrayList<>(10);

        String nameToSearch;

        System.out.println("Enter 5 names");
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

        System.out.println("Enter a name to be searched within a string");
        nameToSearch = sc.nextLine();

        if (checkForName(myList, nameToSearch)) {
            System.out.println("The name exists");
        } else {
            System.out.println("The value you entered does not exist within the list");
        }
    }
}