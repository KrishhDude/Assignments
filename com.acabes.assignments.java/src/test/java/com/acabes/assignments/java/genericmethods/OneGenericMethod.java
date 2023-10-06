package com.acabes.assignments.java.genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneGenericMethod {

    static <T> void genericMethod(List<T> list){
        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        integerList.addAll(Arrays.asList(1,2,3,4,5));
        stringList.addAll(Arrays.asList("Krishnaprasad", "Adithya", "Sanal", "Fincy"));

        genericMethod(integerList);
        genericMethod(stringList);
    }
}
