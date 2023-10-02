package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Scanner;

class Passenger implements BookingSystem {

    Scanner sc = new Scanner(System.in);

    ArrayList<Flight> flights = new ArrayList<>(100);

    public Passenger() {
        for (int i = 0; i < 3; i++) {
            flights.add(new Flight(1000 + i + 1));
        }
    }


    public void addFLight(Flight newFlight){
        flights.add(newFlight);
    }

    public void getFlight() {
        for (Flight flight : flights) {
            System.out.print(flight.flightNumber + ", ");
        }
        System.out.println("\n");
    }

    /*
    public boolean checkIfFlightExists(int flightNumber){
        boolean flightExists = false;
        Flight foundFlight = null;

        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                foundFlight = flight;
                flightExists = true;
                break;
            }
        }
        return flightExists;
    }
    */

    
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
        try {
            if (!flightExists) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            }
            foundFlight.getAvailableSeats();
            System.out.println("How many seats would you like to book?");
            try{
                numOfSeats = sc.nextInt();
                if(numOfSeats%1!=0){
                    throw new InvalidInputException("Invalid Input");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.message);
            }
            foundFlight.bookSeat(numOfSeats);
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
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
        try {
            if (!flightExists) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            } else {
                foundFlight.getAvailableSeats();
                System.out.println("How many seats would you like to cancel?");
                numOfSeats = sc.nextInt();
                foundFlight.cancelSeat(numOfSeats);
            }
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
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
        try {
            if (!flightExists) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            }
            foundFlight.getAvailableSeats();
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        }
    }
}