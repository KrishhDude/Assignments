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
        int flightNumber = sc.nextInt();

        System.out.println("Enter Departure Date: ");
        String departureDate = sc.next();

        System.out.println("Enter Departure Time: ");
        String departureTime = sc.next();

        System.out.println("Enter Departure City: ");
        String departureCity = sc.next();

        System.out.println("Enter Destination City: ");
        String destinationCity = sc.next();

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
                        foundFlight.departureCity = sc.next();
                    } else if (locationEditChoice == 2) {
                        System.out.println("Enter new Arrival Location");
                        foundFlight.destinationCity = sc.next();
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
            /*
            if (choice == 1) {
                if (foundFlight != null) {
                    flights.remove(foundFlight);
                    System.out.println("Flight removed successfully");
                } else {
                    System.out.println("Flight Not Found");
                }


            } else if (choice == 2) {
                System.out.println("Enter new date (dd/mm/yy)");
                foundFlight.departureDate = sc.next();

            } else {
                throw new InvalidInputException("Invalid input. Please enter a valid choice");
            }
             */

        }
    }
}
