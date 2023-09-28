package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Arrays;

class Flight{
    int flightNumber;
    public Flight(int flightNumber){
        this.flightNumber = flightNumber;
    }
    ArrayList<Integer> seats = new ArrayList<Integer>(100);
    public int availableSeats = 100;

    public int getAvailableSeats() {
        return availableSeats;
    }

    void bookSeat(int numOfSeats){
        availableSeats -= numOfSeats;
        System.out.println("Tickets booked for " + numOfSeats + " seats");
        System.out.println("Current available seats : " + availableSeats + "\n");
    }

}

