package com.acabes.assignments.java.collections.testslists;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;

public class TestSortMap {

    static void sortMap(HashMap<String, Integer> hmap) {
        TreeMap<String, Integer> sorted = new TreeMap<>(hmap);

        String result = sorted.entrySet().stream()
                .map(entry -> "Key: " + entry.getKey() +
                        ", Value: " + entry.getValue())
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hmap = new HashMap<>();
        String inputName;
        int inputAge;

        while (true) {
            System.out.println("Enter name and age:\n" +
                    "If stop: Enter stop");
            try{
                inputName = sc.next();
                if (Objects.equals(inputName, "stop")) {
                    break;
                }
                inputAge = sc.nextInt();
                if(inputName.matches("^[a-zA-Z ]+$")) {
                    hmap.put(inputName, inputAge);
                } else {
                    throw new InvalidInputException("Invalid Input");
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: Enter a string for name");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: Enter an integer for age");
                sc.nextLine();
            }
        }
        System.out.println(hmap);
        sortMap(hmap);

    }
}
