package com.acabes.assignments.java.linkedlists;

import java.util.Arrays;
import java.util.LinkedList;

public class AddIntoAnotherLinkedList {
    public static void main(String[] args) {

        LinkedList<Object> list1 = new LinkedList<>();
        LinkedList<Object> list2 = new LinkedList<>();

        list1.addAll(Arrays.asList(1,2,3,4,5));
        list2.addAll(Arrays.asList(6,7,8,9,10));

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        System.out.println("Adding list 2 at first index of list 1");
        list1.addAll(1,list2);
        System.out.println(list1);

    }
}
