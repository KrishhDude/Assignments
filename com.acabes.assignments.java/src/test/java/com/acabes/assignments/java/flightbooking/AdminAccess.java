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

        System.out.println("""
                What would you like to do?
                1. Remove the flight
                2. Change date
                """);
        choice = sc.nextInt();
        if (choice == 1) {
            Flight foundFlight = null;


            for (Flight flight : flights) {
                if (flight.flightNumber == flightNumber) {
                    foundFlight = flight;
                    break;
                }
            }
            if (foundFlight != null) {
                flights.remove(foundFlight);
                System.out.println("Flight removed successfully");
            } else {
                System.out.println("Flight Not Found");
            }


        } else if (choice == 2) {

        } else {
            throw new InvalidInputException("Invalid input. Please enter a valid choice");
        }
    }
}
