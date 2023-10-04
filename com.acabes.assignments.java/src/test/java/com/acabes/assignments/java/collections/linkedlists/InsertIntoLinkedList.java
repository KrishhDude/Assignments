package com.acabes.assignments.java.collections.linkedlists;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class InsertIntoLinkedList {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Object> list = new LinkedList<>();

        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Current Linked list: " + list);
        while(true) {
            try {
                System.out.println("Enter an element to be added to the BEGINNING of the linked list: ");
                list.addFirst(sc.nextInt());

                System.out.println("Enter an element to be added to the END of the linked list: ");
                list.addLast(sc.nextInt());

                System.out.println(list);
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer element");
                sc.nextLine();

            }
        }

    }
}
