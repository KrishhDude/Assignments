package com.acabes.assignments.java.hashsets;

import java.util.HashSet;

class HashSetExample{
    public static void main(String[] args) {
        HashSet <String> hash_Set = new HashSet<>();
        hash_Set.add("Kp");
        hash_Set.add("Adithya");
        hash_Set.add("Fincy");
        hash_Set.add("Sanal");

        System.out.println(hash_Set);

        System.out.println("Does the set contains Adithya? "+hash_Set.contains("Adithya"));
        System.out.println("Is the hash set empty? "+ hash_Set.isEmpty());

        hash_Set.remove("Kp");

        System.out.println(hash_Set);
    }
}