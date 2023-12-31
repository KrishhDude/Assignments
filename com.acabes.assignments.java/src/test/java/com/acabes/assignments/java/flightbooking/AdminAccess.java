package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminAccess {
    private String password = "Admin@123";

    Scanner sc = new Scanner(System.in);

    boolean adminValidation() {
        Scanner sc = new Scanner(System.in);
        String userPassword = "";

        System.out.println("Enter Password: ");
        userPassword = sc.next();
        return password.equals(userPassword);
    }

    Flight findFlightByNumber(int flightNumber, ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                return flight;
            }
        }
        return null;
    }


    void addFLights(ArrayList<Flight> flights) {
        System.out.println("Enter Flight Number: ");
        int flightNumber = 0;
        try {
            flightNumber = sc.nextInt();
            if (flightNumber % 1 != 0) {
                throw new InvalidInputException("Enter a valid integer input");
            }
        } catch (InvalidInputException e) {
            System.out.println(e.message);
        }
        if(findFlightByNumber(flightNumber, flights) != null){
            System.out.println("A flight with that flight number already exists. Please input a new number");
            return;
        }
        System.out.println("Enter Departure Date (dd/mm/yy): ");
        String departureDate = sc.next();
        if (!isValidDate(departureDate)) {
            System.out.println("Invalid date format. Please use dd/mm/yy.");
            return;
        }

        System.out.println("Enter Departure Time: ");
        String departureTime = sc.next();
        if (!isValidTime(departureTime)) {
            System.out.println("Invalid time format. Please use HH:mm.");
            return;
        }

        System.out.println("Enter Departure City: ");
        String departureCity = sc.next().toUpperCase();

        System.out.println("Enter Destination City: ");
        String destinationCity = sc.next().toUpperCase();

        System.out.println("Enter Price: ");
        double price = sc.nextDouble();

        Flight newFlight = new Flight(flightNumber, departureDate, departureTime, departureCity, destinationCity, price);
        flights.add(newFlight);

        System.out.println("Flight added successfully!");
    }

    void editFLights(int flightNumber, ArrayList<Flight> flights) throws InvalidInputException {

        int choice;
        Flight foundFlight = findFlightByNumber(flightNumber, flights);
        boolean editFlag = true;

        while (editFlag) {
            System.out.println("""
                    What would you like to do?
                    1. Remove the flight
                    2. Change date
                    3. Change locations
                    4. Change price
                    5. Exit edit menu
                                    
                    """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (foundFlight != null) {
                        flights.remove(foundFlight);
                        System.out.println("Flight removed successfully");
                    } else {
                        System.out.println("Flight Not Found");
                    }
                    break;

                case 2:
                    System.out.println("Enter new date (dd/mm/yy)");
                    foundFlight.departureDate = sc.next();
                    break;

                case 3:
                    System.out.println("""
                            1. Edit Departure Location
                            2. Edit Arrival Location
                            """);
                    int locationEditChoice = 0;
                    try {
                        locationEditChoice = sc.nextInt();
                        if (locationEditChoice % 1 != 0) {
                            throw new InvalidInputException("Enter a valid integer input");
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.message);
                    }
                    if (locationEditChoice == 1) {
                        System.out.println("Enter new Departure location");
                        foundFlight.departureCity = sc.next().toUpperCase();
                    } else if (locationEditChoice == 2) {
                        System.out.println("Enter new Arrival Location");
                        foundFlight.destinationCity = sc.next().toUpperCase();
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;

                case 4:
                    System.out.println("Enter new price: ");
                    foundFlight.price = sc.nextDouble();

                case 5:
                    System.out.println("Exiting edit menu...");
                    editFlag = false;
                    break;

                default:
                    throw new InvalidInputException("Invalid input. Please enter a valid choice");

            }
        }
    }
    private static boolean isValidDate(String date) {
        // Validate date format (dd/mm/yy)
        String datePattern = "\\d{2}/\\d{2}/\\d{2}";
        return date.matches(datePattern);
    }

    private static boolean isValidTime(String time) {
        // Validate time format (HH:mm)
        String timePattern = "([01][0-9]|2[0-3]):[0-5][0-9]";
        return time.matches(timePattern);
    }

}
