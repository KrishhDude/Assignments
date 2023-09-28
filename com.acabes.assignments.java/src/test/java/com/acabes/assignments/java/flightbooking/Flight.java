package com.acabes.assignments.java.flightbooking;

import java.util.Scanner;

class Flight{
    Scanner sc = new Scanner(System.in);

    int flightNumber;
    int[] seats = new int[100];
    public Flight(int flightNumber){
        this.flightNumber = flightNumber;
        for(int i=0; i<100; i++){
            seats[i]=0;
        }
    }

    public int availableSeats = 100;

    public void getAvailableSeats() {
        System.out.println("There are " + availableSeats + " seats available in this flight.");
        System.out.println("Available seats: ");
        for(int i=0; i<100; i++){
            if(seats[i]==0){
                System.out.print("| S" + (i+1));
            }
        }
        System.out.println("\n");
    }

    void bookSeat(int numOfSeats){
        System.out.println("Which seats would you like to book?");
        for(int i=0; i<numOfSeats; i++){
            int x=sc.nextInt();
            seats[x-1]=1;
        }
        availableSeats -= numOfSeats;
        System.out.println("Tickets booked for " + numOfSeats + " seats");
        for(int i=0; i<numOfSeats; i++){
            if(seats[i]==1){
                System.out.print("| S" + (i+1));
            }
        }
        System.out.println("\n");
        //System.out.println("Current available seats : " + availableSeats + "\n");
    }

    void cancelSeat(int numOfSeats){
        System.out.println("Which seats would you like to cancel?");
        for(int i=0; i<numOfSeats; i++) {
            int x = sc.nextInt();
            if (seats[x - 1] == 1) {
                seats[x - 1] = 0;
            } else {
                System.out.println("Error: That seat is already empty.");
            }
        }
    }

    void displaySeats(int flightNumber){
        System.out.println("Available seats: ");
        for(int i=0; i<100; i++){
            if(seats[i]==0){
                System.out.print("| S" + (i+1));
            }
        }
        System.out.println("\n");
    }

}

