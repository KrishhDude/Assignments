package com.acabes.assignments.java.genericmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericMaps {

    static <T> void printMap(Map<?, ?> map){
        String result = map.entrySet().stream()
                .map(entry -> "Key: " + entry.getKey() +
                        ", Value: " + entry.getValue())
                .collect(Collectors.joining("\n"));

        System.out.println(result);

    }

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        Map<String, String> stringStringMap = new HashMap<>();

        stringIntegerMap.put("Hello", 1);
        stringIntegerMap.put("World", 2);

        stringStringMap.put("Hey", "There");
        stringStringMap.put("Hello", "World");

        printMap(stringIntegerMap);
        printMap(stringStringMap);
    }
}
