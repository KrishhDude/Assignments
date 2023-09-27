package com.acabes.assignments.java.vowelexception;

import java.util.Scanner;

class NotContainVowelException extends Exception{
    public NotContainVowelException(String str){
        super(str);
    }
}

public class StringException {

    static void validateString(String string) throws NotContainVowelException {
        char[] newString = string.toCharArray();
        String vowels = "AEIOUaeiou";
        boolean flag = false;
        for (char c: newString) {
            if (vowels.contains(Character.toString(c))) {
                System.out.println("Found a vowel: "+ c);
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new NotContainVowelException("No vowels found in string");
        }
    }

    public static void main(String[] args) throws NotContainVowelException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = sc.nextLine();

        validateString(inputString);

    }
}
