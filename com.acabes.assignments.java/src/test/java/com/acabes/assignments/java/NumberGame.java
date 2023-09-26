package com.acabes.assignments.java;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userGuess, count = 0;

        //generate a random integer
        Random rand = new Random();
        int computerGuess = rand.nextInt(100 - 1) + 1;

        System.out.println("The number I have guessed lies between 0 and 1.\nCan You Guess It?");

        do {
            System.out.println("Enter your guess");
            userGuess = sc.nextInt();
            if (userGuess < computerGuess) {
                if (Math.abs(userGuess - computerGuess) < 5) {              //Checks if the user is within 5 numbers of system's guess
                    System.out.println("Really close, but you guessed a bit lower");
                } else {
                    System.out.println("You guessed lower");
                }
            }
            if (userGuess > computerGuess){
                if (Math.abs(userGuess - computerGuess) < 5) {
                    System.out.println("Really close, but you guessed a bit higher");
                } else {
                    System.out.println("You guessed higher");
                }
            }
            if (userGuess == computerGuess) {
                System.out.println("CONGRATULATIONS!!, the number was indeed " + userGuess);
                System.out.println("You took " + count + " tries to get to the guess");
                break;
            }
            count++;
        } while (userGuess != computerGuess);
    }
}
