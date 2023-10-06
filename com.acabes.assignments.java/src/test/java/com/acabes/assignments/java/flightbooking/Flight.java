package com.acabes.assignments.java.flightbooking;

import com.acabes.assignments.java.banking.BankingMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Flight {
    Scanner sc = new Scanner(System.in);

    int flightNumber;
    String departureDate;
    String departureTime;
    String departureCity;
    String destinationCity;
    double price;

    int[] seats = new int[100];
    public int availableSeats = 100;

    //HashMap<Integer, Flight> bookingIdMap = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> bookingIdMap = new HashMap<>();
    ArrayList<Integer> bookedSeats = new ArrayList<>();
    int bookingId = 100;

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

    public void displayFlightDetails() {
        System.out.println("\nFlight Details for flight " + flightNumber + ": \n");
        System.out.println("Departure date: " + departureDate);
        System.out.println("Departure time: " + departureTime);
        System.out.println("Departure city: " + departureCity);
        System.out.println("Destination city: " + destinationCity);
        System.out.println("Price: $" + price);
        System.out.println("Available Seats: " + availableSeats);
    }

    void bookSeat(int numOfSeats, Flight foundFlight) throws InvalidInputException {
        ArrayList<Integer> bookedSeats = new ArrayList<>();

        System.out.println("Which seats would you like to book?");
        for (int i = 0; i < numOfSeats; i++) {
            int seatNumber = 0;
            try {
                seatNumber = sc.nextInt();
                if (seatNumber < 1 || seatNumber > 100) {
                    i--;
                    throw new InvalidInputException("");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: Please enter a valid seat number");
                return;
            }
            if (seats[seatNumber - 1] == 0) {

                seats[seatNumber - 1] = 1;
                bookedSeats.add(seatNumber);
            } else {
                System.out.println("Error: That seat is already booked,please book another seat");
            }
        }
        System.out.println("\nTotal amount for your booking: " + numOfSeats * foundFlight.price);
        System.out.println("Do you want to continue? \n\t 1. Yes \t2 No");
        if(sc.nextInt() == 1){
            bookingIdMap.put(bookingId, bookedSeats);
            System.out.println("Redirecting to payment portal...");
            BankingMain.flightRedirect(numOfSeats, price, false);

            availableSeats -= numOfSeats;
            System.out.println("\nYour Booking Id :" + bookingId);
            bookingId++;
            System.out.println("Tickets booked for " + numOfSeats + " seats");
            System.out.println(bookedSeats);
        } else {
            System.out.println("Cancelling booking process...");
            for(int i=0; i<numOfSeats; i++) {
                seats[bookedSeats.get(i) -1] = 0;
            }
        }
    }

    void cancelSeat(int numOfSeats, int bookingId) throws InvalidInputException {
        System.out.println("Which seats would you like to cancel?");
        for (int i = 0; i < numOfSeats; i++) {
            int seatNum = sc.nextInt();
            if ((seats[seatNum - 1] == 1) && bookingIdMap.containsKey(bookingId)) {
                if (bookedSeats.contains(seatNum)) {
                    seats[seatNum - 1] = 0;
                    bookedSeats.remove(Integer.valueOf(seatNum));
                }
            } else {
                System.out.println("Error: That seat is already empty or does not belong to your booking. Please try again");
                return;
            }
        }
        BankingMain.flightRedirect(numOfSeats, price, true);
        availableSeats += numOfSeats;
    }

    void displayBookedSeats(int bookingId) {
        //System.out.println(bookingIdMap);
        if (bookingIdMap.containsKey(bookingId)) {
            ArrayList<Integer> bookedSeats = bookingIdMap.get(bookingId);

            System.out.println("Booked seats for Booking ID " + bookingId + ":");
            for (Integer seat : bookedSeats) {
                System.out.print("S" + seat + " ");
            }
            System.out.println("\nTotal " + bookedSeats.size() + " seats booked");
            System.out.println();
        } else {
            System.out.println("Booking ID " + bookingId + " not found.");
        }
    }
}

