package com.acabes.assignments.java.collections.testslists;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class TestMapStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> friends = new HashMap<>();
        String searchKey;

        friends.put("test name", 22);
        friends.put("Fincy", 23);
        friends.put("Adithya", 23);
        friends.put("abcd", 35);

        System.out.println("Map: " + friends);

        while (true) {
            System.out.println("Enter key(name) to be searched");
            try {
                searchKey = sc.nextLine();
                if (searchKey.matches("^[a-zA-Z ]+$")) {
                    break;
                } else {
                    throw new InvalidInputException("Invalid Input");
                }
            } catch (InvalidInputException e) {
                System.out.println("Please enter a string value");
            }
        }

        System.out.println("Using java streams: ");
        String finalSearchKey = searchKey;
        Optional<Integer> findKey = friends.entrySet().stream()
                .filter(e -> finalSearchKey.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        System.out.println("age: " + findKey.get());


    }
}
