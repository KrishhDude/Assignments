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
            System.out.print(flight.flightNumber + ", ");
        }
        System.out.println("\n");
    }

    public void bookFlight(int flightNumber) {
        int numOfSeats = 0;
        boolean flightExists = false;
        Flight foundFlight = null;

        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                foundFlight = flight;
                flightExists = true;
                break;
            }
        }

        if (!flightExists) {
            System.out.println("The flight you requested does not exist. Please check again...\n");
        } else {
            System.out.println("Available Seats for " + flightNumber + ": " + foundFlight.availableSeats);
            System.out.println("How many seats would you like to book?");
            numOfSeats = sc.nextInt();
            foundFlight.bookSeat(numOfSeats);
        }
    }


    public void cancelFlight() {

    }

    public void displaySeatAvailability() {

    }

}