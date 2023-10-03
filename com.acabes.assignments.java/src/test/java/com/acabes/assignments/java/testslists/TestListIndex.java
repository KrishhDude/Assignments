package com.acabes.assignments.java.testslists;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class TestListIndex {

    static void searchTown(HashMap<String,String> hmap, String name){
        if(hmap.containsKey(name)){
            String townName = hmap.get(name);
            System.out.println("Town of " + name + " is " + townName);
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

            inputName = sc.nextLine();
            if(Objects.equals(inputName, "stop")){
                break;
            }
            inputTown = sc.nextLine();
            hmap.put(inputName, inputTown);
        }
        System.out.println(hmap);

        System.out.println("Enter friend whose town need to be searched:");
        searchTown(hmap, sc.nextLine());

    }
}
