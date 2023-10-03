package com.acabes.assignments.java.testslists;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class TestMapStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        Map<String,Integer> friends= stringIntegerHashMap;

        friends.put("Kp", 22);
        friends.put("Fincy", 23);

        System.out.println("Map: " + friends);

        System.out.println("Enter key(name) to be searched");
        String searchKey = sc.next();

        /*
        if(friends.containsKey(searchKey)){
            System.out.println("Found Key.");
            System.out.println("Key details: " + friends.get(searchKey));
        }
        */

        System.out.println("Using java streams: ");
        Optional<Integer> findKey = friends.entrySet().stream()
                                    .filter(e -> searchKey.equals(e.getKey()))
                                    .map(Map.Entry :: getValue)
                                    .findFirst();
        System.out.println(findKey.get());


    }
}
