package com.acabes.assignments.java.arrayindexexception;

import java.util.Scanner;

public class ArrayIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,2,3,4,5};

        try{
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("Index you're trying to access is out of bounds");
        }
    }
}
