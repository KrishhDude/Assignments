package com.acabes.assignments.java.testslists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestList {

    static void printList(){}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameToRemove;

        List<String> myList = new ArrayList<>(10);
        //Iterator<String> iter = myList.iterator();

        System.out.println("Enter names");
        for(int i=0; i<10; i++){
            myList.add(sc.nextLine());
        }

        System.out.println(myList);

        System.out.println("Enter name to remove:");
        nameToRemove = sc.next();
        myList.remove(nameToRemove);

        System.out.println(myList);

    }
}
