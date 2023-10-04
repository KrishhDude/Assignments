package com.acabes.assignments.java.collections.treemaps;

import java.util.TreeMap;

public class TreeMapFunctions {
    public static void main(String[] args) {
        TreeMap<Integer, String> treemap = new TreeMap<>();

        treemap.put(1, "Kp");
        treemap.put(2, "Adithya");
        treemap.put(3, "Fincy");

        System.out.println(treemap);

        System.out.println("Searching for name Fincy in treemap:");
        if (treemap.containsValue("Fincy")) {
            System.out.println("Name exists");
        } else {
            System.out.println("Fincy doesn't exist");
        }

        System.out.println("Removing roll no. 1 from treemap");
        treemap.remove(1);
        System.out.println(treemap);
    }
}
