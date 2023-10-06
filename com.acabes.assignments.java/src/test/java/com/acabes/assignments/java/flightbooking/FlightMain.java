package com.acabes.assignments.java.flightbooking;

import com.acabes.assignments.java.banking.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightMain {

    private static void displayFlightDetails(ArrayList<Flight> flights, int flightNumber) {


        boolean flightExists = false;
        for (Flight flight : flights) {
            if (flight.flightNumber == flightNumber) {
                flightExists = true;
                flight.displayFlightDetails();
                break;
            }
        }
        if (!flightExists) {
            System.out.println("Flight with Flight Number " + flightNumber + " not found.");
        }
    }

    public static void main(String[] args) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        Passenger passenger = new Passenger();
        AdminAccess admin = new AdminAccess();
        int userType;
        System.out.println("HELLO AND WELCOME TO MODEL AIRWAYS");
        while (true) {
            System.out.println("""
                                    
                    How would you like to sign in?
                    1. User
                    2. Admin
                    3. Exit system
                    """);
            userType = sc.nextInt();
            if (userType == 1) {
                boolean flag = true;
                while (flag) {
                    System.out.println("""
                                                
                            What do you want to do today?
                            \t1. Search for a flight
                            \t2. Display flight details
                            \t3. Book a flight
                            \t4. Cancel your booking
                            \t5. Display seats availability
                            \t6. View your booking details
                            \t7. Exit the system
                            
                            """);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> passenger.searchFlight();
                        case 2 -> {
                            System.out.println("Enter the flight number:");
                            int selectedFlightNumber = sc.nextInt();
                            displayFlightDetails(passenger.flights, selectedFlightNumber);
                        }
                        case 3 -> {
                            System.out.println("For which flight would you like to book?\n" +
                                    "Please Enter the Flight Number");
                            int flightNumber = sc.nextInt();
                            passenger.bookFlight(flightNumber);
                        }
                        case 4 -> {
                            System.out.println("Which flight did you want to cancel seats for?");
                            int flightNumber = sc.nextInt();
                            System.out.println("Please enter your Booking ID: ");
                            int bookingId = sc.nextInt();
                            passenger.cancelFlight(flightNumber, bookingId);
                        }
                        case 5 -> {
                            passenger.displaySeatAvailability();
                        }
                        case 6 -> {
                            System.out.println("Enter the flight number");
                            int flightNumber = sc.nextInt();
                            System.out.println("Enter your Booking ID");
                            int bookingId = sc.nextInt();
                            passenger.viewBookingDetails(flightNumber, bookingId);
                        }
                        case 7 -> flag = false;

                        default -> {
                            System.out.println("Unexpected Value: " + choice);
                            System.out.println("Please enter a value of the given options");
                        }
                    }
                }
            } else if (userType == 2) {
                if (admin.adminValidation()) {
                    System.out.println("Success");
                    boolean adminFlag = true;
                    while (adminFlag) {
                        System.out.println("""
                                                                        
                                What would you like to do today?
                                1. View the flight directory
                                2. View flight details
                                3. Add a new flight
                                4. Edit current flights
                                5. Exit
                                """);
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("The following flights have been added:");
                                passenger.getFlight();
                                break;
                            case 2:
                                System.out.println("Enter the flight number:");
                                int selectedFlightNumber = sc.nextInt();
                                displayFlightDetails(passenger.flights, selectedFlightNumber);
                                break;
                            case 3:
                                admin.addFLights(passenger.flights);
                                break;
                            case 4:
                                System.out.println("Which flight would you like to edit");
                                int flightNumber = sc.nextInt();
                                admin.editFLights(flightNumber, passenger.flights);
                                break;
                            case 5:
                                System.out.println("Exiting admin module...");
                                adminFlag = false;
                                break;
                            default:
                                System.out.println("Unexpected Value: " + choice);
                                System.out.println("Please enter a value of the given options");
                        }
                    }
                } else {
                    System.out.println("Invalid Password. Try Again");
                }

            } else if (userType == 3) {
                System.out.println("Thank-you for choosing us! Bye bye..");
                break;
            } else {
                System.out.println("Please choose on of the given options");
            }
        }
    }
}
