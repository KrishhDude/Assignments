package com.acabes.assignments.java.collections.stringfunctions;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        String stringToReverse = "";

        System.out.println("Enter a string to be reversed");
        stringToReverse = sc.next();

        StringBuilder reversedString = new StringBuilder();

        char ch;
        System.out.println(stringToReverse);

        for (int i = 0; i < stringToReverse.length(); i++) {
            ch = stringToReverse.charAt(i);
            reversedString.insert(0, ch);
        }
        System.out.println("Reversed string: " + reversedString);
    }
}