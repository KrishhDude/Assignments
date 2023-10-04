package com.acabes.assignments.java.collections.stringfunctions;

public class ReverseString {
    public static void main(String[] args) {

        String stringToReverse = "Hello World";
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