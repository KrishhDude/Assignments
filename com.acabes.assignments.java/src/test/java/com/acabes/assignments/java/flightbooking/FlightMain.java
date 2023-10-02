package com.acabes.assignments.java.flightbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightMain {

    private static void displayFlightDetails(ArrayList<Flight> flights, int flightNumber){
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
        System.out.println("""
                Hello and Welcome to Model Airways
                How would you like to sign in?
                1. User
                2. Admin
                """);
        userType = sc.nextInt();
        if(userType == 1){
            boolean flag = true;
            while (flag) {
                System.out.println("""
                    What do you want to do today?
                    1. Get the flights running today
                    2. Book a flight
                    3. Cancel your booking
                    4. Display seats availability
                    5. Exit the system
                    """);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> passenger.getFlight();
                    case 2 -> {
                        System.out.println("For which flight would you like to book?");
                        int flightNumber = sc.nextInt();
                        passenger.bookFlight(flightNumber);
                    }
                    case 3 -> {
                        System.out.println("Which flight did you want to cancel seats for?");
                        int flightNumber = sc.nextInt();
                        passenger.cancelFlight(flightNumber);
                    }
                    case 4 -> {
                        passenger.displaySeatAvailability();
                    }
                    case 5 -> flag = false;

                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        } else if (userType == 2) {
            if(admin.adminValidation()){
                System.out.println("Success");
                while(true){
                    System.out.println("""
                                        What would you like to do today?
                                        1. View the flight directory
                                        2. View flight details
                                        3. Add a new flight
                                        4. Edit current flights
                                        5. Exit
                                        """);
                    int choice = sc.nextInt();
                    switch (choice){
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
//                            System.out.println("Enter the flight number of a flight to be added");
//                            int newFlightNumber = sc.nextInt();
//                            passenger.addFLight(new Flight(newFlightNumber));
//                            System.out.println("Added flight: " + newFlightNumber + "to the directory");
                            break;
                        case 4:
                            System.out.println("Which flight would you like to edit");
                            int flightNumber = sc.nextInt();
                            admin.editFLights(flightNumber, passenger.flights);
                            break;
                        case 5:
                            System.out.println("Exiting admin module...");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + choice);
                    }






                }
            } else {
                System.out.println("Invalid Password. Try Again");
            }

        } else {
            throw new InvalidInputException("Invalid Input");
        }
    }
}
