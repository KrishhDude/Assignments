package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Scanner;

class Passenger implements BookingSystem {

    Scanner sc = new Scanner(System.in);

    ArrayList<Flight> flights = new ArrayList<>(100);
    public Passenger() {
        for(int i=0; i<3; i++){
            flights.add(new Flight(1000+i+1));
        }
    }
//    Flight[] flights = {
//            new Flight(1001),
//            new Flight(1002),
//            new Flight(1003)
//    };

    public void getFlight() {
        for (Flight flight : flights) {
            System.out.print(flight.flightNumber + ", ");
        }
        System.out.println("\n");
    }

    //public boolean checkIfFlightExists

    public void bookFlight(int flightNumber) {
        //ArrayList<Integer> bookingNumber = new ArrayList<Integer>();
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
            foundFlight.getAvailableSeats();
            System.out.println("How many seats would you like to book?");
            numOfSeats = sc.nextInt();
            foundFlight.bookSeat(numOfSeats);
        }
    }


    public void cancelFlight(int flightNumber) {
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
            foundFlight.getAvailableSeats();
            System.out.println("How many seats would you like to cancel?");
            numOfSeats = sc.nextInt();
            foundFlight.cancelSeat(numOfSeats);
        }
    }

    public void displaySeatAvailability() {
        System.out.println("Enter the flight number: ");
        int flightNumber = sc.nextInt();
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
            foundFlight.getAvailableSeats();
        }
    }

}