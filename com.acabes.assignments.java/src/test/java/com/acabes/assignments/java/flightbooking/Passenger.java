package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Scanner;

class Passenger implements BookingSystem {

    Scanner sc = new Scanner(System.in);

    ArrayList<Flight> flights = new ArrayList<>(100);


    public void searchFlight(){
        System.out.println("Enter departure date [in dd/mm/yy format]");
        String searchDepartureDate = sc.next();

        System.out.println("Enter Departure City: ");
        String searchDepartureCity = sc.next();

        System.out.println("Enter Destination City: ");
        String searchDestinationCity = sc.next();

        displayQueryFlights(searchDepartureDate, searchDepartureCity, searchDestinationCity);
    }

    private void displayQueryFlights(String depDate, String depCity, String destCity){
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

    private Flight findFlightByNumber (int flightNumber ){
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
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
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