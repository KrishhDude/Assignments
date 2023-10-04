package com.acabes.assignments.java.collections.hashsets;

import java.util.HashSet;

class HashSetExample{
    public static void main(String[] args) {
        HashSet <String> hashSet = new HashSet<>();
        hashSet.add("Kp");
        hashSet.add("Adithya");
        hashSet.add("Fincy");
        hashSet.add("Sanal");

        System.out.println(hashSet);

        System.out.println("Does the set contains Adithya? "+hashSet.contains("Adithya"));
        System.out.println("Is the hash set empty? "+ hashSet.isEmpty());

        hashSet.remove("Kp");

        System.out.println(hashSet);
    }
}