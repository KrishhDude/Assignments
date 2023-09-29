package com.acabes.assignments.java.testslists;

import java.util.*;

public class TestSortMap {

    static void sortMap(HashMap<String, Integer> hmap){
        TreeMap<String, Integer> sorted = new TreeMap<>(hmap);
        for(Map.Entry<String, Integer> entry: sorted.entrySet()) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hmap = new HashMap<>();
        boolean flag = true;
        String inputName;
        int inputAge;

        while(flag){
            System.out.println("Enter name and age:\n" +
                    "If stop: Enter stop");

            inputName = sc.next();
            if(Objects.equals(inputName, "stop")){
                break;
            }
            inputAge = sc.nextInt();
            hmap.put(inputName, inputAge);
        }
        System.out.println(hmap);
        sortMap(hmap);

    }
}
