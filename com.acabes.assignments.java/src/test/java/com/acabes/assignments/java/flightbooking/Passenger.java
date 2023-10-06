package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Passenger implements BookingSystem {

    Scanner sc = new Scanner(System.in);
    ArrayList<Flight> flights = new ArrayList<>();

    public Passenger() {
        Flight[] flightArray = {
                new Flight(1001, "12/12/23", "09:00", "COCHIN", "DUBAI", 120),
                new Flight(1002, "13/12/23", "18:00", "DUBAI", "COCHIN", 150),
                new Flight(1003, "10/12/23", "23:00", "COCHIN", "JFK", 200),
                new Flight(1004, "09/12/23", "15:45", "COCHIN", "NEWYORK", 250),
                new Flight(1005, "15/12/23", "00:50", "COCHIN", "AMMAN", 200),
                new Flight(1006, "10/12/23", "01:50", "AMMAN", "COCHIN", 250),
                new Flight(1007, "09/12/23", "03:00", "COCHIN", "PERTH", 300),
                new Flight(1008, "01/12/23", "19:45", "PERTH", "COCHIN", 300),
                new Flight(1009, "30/12/23", "15:30", "COCHIN", "DELHI", 75),
                new Flight(1010, "14/12/23", "07:20", "DELHI", "COCHIN", 80)
        };
        flights.addAll(Arrays.asList(flightArray));
    }

    public void searchFlight() {
        System.out.println("Enter departure date [in dd/mm/yy format]");
        String searchDepartureDate = sc.next();
        if (!isValidDate(searchDepartureDate)) {
            System.out.println("Invalid date format. Please use dd/mm/yy.");
            return;
        }

        System.out.println("Enter Departure City: ");
        String searchDepartureCity = sc.next().toUpperCase();
        if (!isValidString(searchDepartureCity)) {
            System.out.println("Invalid format for city name. Please do-not use numbers or special characters");
            return;
        }

        System.out.println("Enter Destination City: ");
        String searchDestinationCity = sc.next().toUpperCase();
        if (!isValidString(searchDestinationCity)) {
            System.out.println("Invalid format for city name. Please do-not use numbers or special characters");
            return;
        }
        System.out.println("\nAVAILABLE FLIGHTS: ");
        displayQueryFlights(searchDepartureDate, searchDepartureCity, searchDestinationCity);
    }

    private boolean isValidDate(String date) {
        // Validate date format (dd/mm/yy)
        String datePattern = "\\d{2}/\\d{2}/\\d{2}";
        return date.matches(datePattern);
    }

    private boolean isValidString(String city) {
        String cityPattern = "^[a-zA-Z ]+$";
        return city.matches(cityPattern);
    }

    private void displayQueryFlights(String depDate, String depCity, String destCity) {
        boolean foundFlights = false;

        //System.out.println("\nMatching Flights: ");
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
                if (numOfSeats < 1 || numOfSeats > 100) {
                    throw new InvalidInputException("");
                }
                foundFlight.bookSeat(numOfSeats, foundFlight);
            } catch (InvalidInputException | InputMismatchException e) {
                System.out.println("Error: Please enter a number between 1 and 100");
                sc.nextLine();
            }
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        }
    }


    public void cancelFlight(int flightNumber, int bookingId) {
        int numOfSeats = 0;
        Flight foundFlight = findFlightByNumber(flightNumber);
        try {
            if (foundFlight == null) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            } else {
                foundFlight.displayBookedSeats(bookingId);

                System.out.println("How many seats would you like to cancel?");
                numOfSeats = sc.nextInt();
                foundFlight.cancelSeat(numOfSeats, bookingId);
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

    public void viewBookingDetails(int flightNumber, int bookingId) {
        Flight foundFlight = findFlightByNumber(flightNumber);
        try {
            if (foundFlight == null) {
                throw new FlightNotFoundException("Error: This Flight doesn't exist");
            }
            foundFlight.displayBookedSeats(bookingId);
        } catch (FlightNotFoundException e) {
            System.out.println(e.message);
        }
    }
}