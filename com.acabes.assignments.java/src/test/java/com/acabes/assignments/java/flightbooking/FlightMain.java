package com.acabes.assignments.java.flightbooking;

import java.util.Scanner;

public class FlightMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Passenger passenger = new Passenger();
        System.out.println("Hello and Welcome to Model Airways\n" +
                            "What would you like to do today?\n");
        boolean flag = true;
        while(flag){
            System.out.println("1. Get the flights running today\n" +
                                "2. Book a flight\n" +
                                "3. Cancel your booking\n" +
                                "4. Display seats availability\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> passenger.getFlight();
                case 2 -> {
                    System.out.println("For which flight would you like to book?");
                    int flightNumber = sc.nextInt();
                    passenger.bookFlight(flightNumber);
                    break;
                }
                case 3 ->{
                    System.out.println("Which flight did you want to cancel seats for?");
                    int flightNumber = sc.nextInt();
                    passenger.cancelFlight(flightNumber);
                }
                case 4 ->{
                    passenger.displaySeatAvailability();
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
