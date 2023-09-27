package com.acabes.assignments.java.flightbooking;

import java.util.Scanner;

class Passenger implements BookingSystem{

    Scanner sc = new Scanner(System.in);
    Flight[] flights = {
            new Flight(1001),
            new Flight(1002),
            new Flight(1003)
    };

    public void getFlight(){
        for(Flight flight: flights){
            System.out.println(flight.flightNumber + "\n");
        }
    }

    public void bookFlight(int flightNumber) {
        System.out.println("Available Seats for " + flightNumber + ":");
        for(Flight flight: flights){
            boolean flightExists = false;
            if(flight.flightNumber != flightNumber) {
                System.out.println(flight.availableSeats);
            } else {
                System.out.println("\nNo such flight exists. Did you enter correctly?\n");
            }
        }
    }

    public void cancelFlight() {

    }

    public void displaySeatAvailability() {

    }

}