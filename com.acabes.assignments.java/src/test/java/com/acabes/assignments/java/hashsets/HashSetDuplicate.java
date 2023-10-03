package com.acabes.assignments.java.hashsets;
import java.util.Collections;
import java.util.HashSet;

class HashSetDuplicate{

    static boolean hasDuplicateValue(HashSet hashSet1, HashSet hashSet2){
        return !Collections.disjoint(hashSet1,hashSet2);
    }

    public static void main(String [] args){
        HashSet <String> hashSet1 = new HashSet<>();
        HashSet <String> hashSet2 = new HashSet<>();

        hashSet1.add("Kp");
        hashSet1.add("Adithya");

        hashSet2.add("Kp");
        hashSet2.add("Fincy");

        System.out.println("Does two hashsets share a duplicate value? "+ hasDuplicateValue(hashSet1, hashSet2));
    }
}