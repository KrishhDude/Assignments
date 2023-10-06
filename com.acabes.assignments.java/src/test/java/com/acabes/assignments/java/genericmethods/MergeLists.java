package com.acabes.assignments.java.genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeLists {

    static <T> void mergeLists(List<T> list1, List<T> list2) {
        list1.addAll(list2);
        System.out.println("Merged lists: " + list1);

    }

    public static void main(String[] args) {

        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 0));

        List<String> stringList1 = new ArrayList<>(Arrays.asList("Hello", "World"));
        List<String> stringList2 = new ArrayList<>(Arrays.asList("Hey", "There"));

        mergeLists(integerList1, integerList2);
        mergeLists(stringList1, stringList2);
    }
}
