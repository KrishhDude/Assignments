package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Passenger implements BookingSystem {

    Scanner sc = new Scanner(System.in);

    ArrayList<Flight> flights = new ArrayList<>();

    public Passenger(){
        Flight[] flightArray = {
                new Flight(1001, "12/12/23", "09:00", "COCHIN", "DUBAI", 120),
                new Flight(1002, "13/12/23", "18:00", "DUBAI", "COCHIN", 150),
                new Flight(1003, "10/12/23", "23:00", "COCHIN", "JFK", 200),
                new Flight(1004, "09/12/23", "15:45", "COCHIN", "NEWYORK", 250),
                new Flight(1005, "15/12/23", "00:50", "COCHIN", "AMMAN", 200),
                new Flight(1005, "10/12/23", "01:50", "AMMAN", "COCHIN", 250),
                new Flight(1005, "09/12/23", "03:00", "COCHIN", "PERTH", 300),
                new Flight(1005, "01/12/23", "19:45", "PERTH", "COCHIN", 300),
                new Flight(1005, "30/12/23", "15:30", "COCHIN", "DELHI", 75),
                new Flight(1005, "14/12/23", "07:20", "DELHI", "COCHIN", 80)
        };

        // Ensure that Flight class has a proper toString() method or modify this loop accordingly
        flights.addAll(Arrays.asList(flightArray));
    }

    public void searchFlight() {
        System.out.println("Enter departure date [in dd/mm/yy format]");
        String searchDepartureDate = sc.next();

        System.out.println("Enter Departure City: ");
        String searchDepartureCity = sc.next().toUpperCase();

        System.out.println("Enter Destination City: ");
        String searchDestinationCity = sc.next().toUpperCase();

        displayQueryFlights(searchDepartureDate, searchDepartureCity, searchDestinationCity);
    }

    private void displayQueryFlights(String depDate, String depCity, String destCity) {
        boolean foundFlights = false;

        System.out.println("\nMatching Flights: ");
        for (Flight flight : flights) {
            if (flight.departureDate.equals(depDate) &&
                    flight.departureCity.equalsIgnoreCase(depCity) &&
                    flight.destinationCity.equalsIgnoreCase(destCity)) {
                foundFlights = true;
                flight.displayFlightDetails();
                System.out.println("-----------------------");
            }
        }

        if (!foundFlights) {
            System.out.println("No matching flights found for the specified criteria.");
        }
    }

    public void getFlight() {
        for (Flight flight : flights) {
            System.out.print(flight.flightNumber + ", ");
        }
        System.out.println("\n");
    }

    private Flight findFlightByNumber(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void bookFlight(int flightNumber) {
        int numOfSeats = 0;
        Flight foundFlight = findFlightByNumber(flightNumber);
        try {
            if (foundFlight == null) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            }
            foundFlight.getAvailableSeats();
            System.out.println("How many seats would you like to book?");
            try {
                numOfSeats = sc.nextInt();
                if (numOfSeats % 1 != 0) {
                    throw new InvalidInputException("Invalid Input");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.message);
            }
            foundFlight.bookSeat(numOfSeats);
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        } catch (InvalidInputException e) {
            System.out.println(e.message);
        }

    }


    public void cancelFlight(int flightNumber) {
        int numOfSeats = 0;
        Flight foundFlight = findFlightByNumber(flightNumber);
        try {
            if (foundFlight == null) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            } else {
                foundFlight.getBookedSeats();
                System.out.println("How many seats would you like to cancel?");
                numOfSeats = sc.nextInt();
                foundFlight.cancelSeat(numOfSeats);
            }
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    public void displaySeatAvailability() {
        System.out.println("Enter the flight number: ");
        int flightNumber = sc.nextInt();
        Flight foundFlight = findFlightByNumber(flightNumber);
        try {
            if (foundFlight == null) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            }
            foundFlight.getAvailableSeats();
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        }
    }
    
    /*
     Redundant code, putting here just for reference
        boolean flightExists = false;
        Flight foundFlight = null;

        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                foundFlight = flight;
                flightExists = true;
                break;
            }
        }
     */
}