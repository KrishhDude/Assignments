package com.acabes.assignments.java.collections.testslists;

import com.acabes.assignments.java.flightbooking.InvalidInputException;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class TestListIndex {

    static void searchTown(HashMap<String,String> hmap, String name){
        if(hmap.containsKey(name)){
            String townName = hmap.get(name);
            System.out.println("Town of " + name + " is " + townName);
        } else {
            System.out.println("The value " + name + "does not exist within the list");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> hmap = new HashMap<>();
        boolean flag = true;
        String inputName;
        String inputTown;

        while(flag){
            System.out.println("Enter name and town:\n" +
                    "If stop: Enter stop");

            try{
                inputName = sc.nextLine();
                if(Objects.equals(inputName, "stop")){
                    break;
                }
                inputTown = sc.nextLine();
                if(inputName.matches("^[a-zA-Z ]+$") && inputTown.matches("^[a-zA-Z ]+$")) {
                    hmap.put(inputName, inputTown);
                } else {
                    throw new InvalidInputException("Invalid Input");
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, please enter a string value for name and town");
            }
        }
        System.out.println(hmap);

        System.out.println("Enter friend whose town need to be searched:");
        searchTown(hmap, sc.nextLine());

    }
}
