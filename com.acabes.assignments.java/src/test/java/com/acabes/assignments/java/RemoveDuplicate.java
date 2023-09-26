package com.acabes.assignments.java;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicate {
    static void removeDuplicates(char[] str){
        int i;
        int j;
        int size=str.length;
        int index=0;
        for(i=0; i<size; i++) {
            for (j = 0; j < i; j++) {
                if (str[i] == str[j])
                    break;
            }
            if (i == j)
                str[index++] = str[i];
        }
        System.out.println(String.valueOf(Arrays.copyOf(str, index)));
    }
    public static void  main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a string");
        String userString = userInput.nextLine();
        char [] str = userString.toCharArray();
        removeDuplicates(str);

    }
}
