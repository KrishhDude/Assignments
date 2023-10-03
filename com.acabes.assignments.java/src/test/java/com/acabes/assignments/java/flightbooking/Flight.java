package com.acabes.assignments.java.flightbooking;

import com.acabes.assignments.java.banking.BankingMain;

import java.util.Scanner;
import java.util.Timer;

class Flight {
    Scanner sc = new Scanner(System.in);

    int flightNumber;
    String departureDate;
    String departureTime;
    String departureCity;
    String destinationCity;
    double price;

    int[] seats = new int[100];

    public Flight(int flightNumber, String departureDate, String departureTime,
                  String departureCity, String destinationCity, double price) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.price = price;
        for (int i = 0; i < 100; i++) {
            seats[i] = 0;
        }
    }

    public int availableSeats = 100;

    public void getAvailableSeats() {
        System.out.println("There are " + availableSeats + " seats available in this flight.");
        System.out.println("Available seats: ");
        for (int i = 0; i < 100; i++) {
            if (seats[i] == 0) {
                System.out.print("| S" + (i + 1));
                if ((100 - i - 1) % 25 == 0) {
                    System.out.println("\n");
                }
            }
        }
        System.out.println("\n");
    }

    public void getBookedSeats() {
        System.out.println((100 - availableSeats) + " seats are booked");
        System.out.println("Booked seats: ");
        for (int i = 0; i < 100; i++) {
            if (seats[i] == 1) {
                System.out.print("| S" + (i + 1));
                if ((100 - i - 1) % 25 == 0) {
                    System.out.println("\n");
                }
            }
        }
        System.out.println("\n");
    }

    public void displayFlightDetails() {
        System.out.println("\nFlight Details for flight " + flightNumber + ": \n");
        System.out.println("Departure date: " + departureDate);
        System.out.println("Departure time: " + departureTime);
        System.out.println("Departure city: " + departureCity);
        System.out.println("Destination city: " + destinationCity);
        System.out.println("Price: $" + price);
        System.out.println("Available Seats: " + availableSeats);
    }

    void bookSeat(int numOfSeats) throws InvalidInputException {
        System.out.println("Which seats would you like to book?");
        for (int i = 0; i < numOfSeats; i++) {
            int x = sc.nextInt();
            if (seats[x - 1] == 0) {
                seats[x - 1] = 1;
            } else {
                System.out.println("Error: That seat is already booked,please book another seat");
            }
        }
        System.out.println("Redirecting to payment portal...");
        BankingMain.flightRedirect(numOfSeats, price, false);


        availableSeats -= numOfSeats;
        System.out.println("\nTickets booked for " + numOfSeats + " seats");
        for (int i = 0; i < numOfSeats; i++) {
            if (seats[i] == 1) {
                System.out.print("| S" + (i + 1));
            }
        }
        System.out.println("\n");
    }

    void cancelSeat(int numOfSeats) throws InvalidInputException {
        System.out.println("Which seats would you like to cancel?");
        for (int i = 0; i < numOfSeats; i++) {
            int x = sc.nextInt();
            if (seats[x - 1] == 1) {
                seats[x - 1] = 0;
            } else {
                System.out.println("Error: That seat is already empty.");
            }
        }
        BankingMain.flightRedirect(numOfSeats, price, true);
        availableSeats += numOfSeats;
    }

    void displaySeats(int flightNumber) {
        System.out.println("Available seats: ");
        for (int i = 0; i < 100; i++) {
            if (seats[i] == 0) {
                System.out.print("| S" + (i + 1));
            }
        }
        System.out.println("\n");
    }

}

