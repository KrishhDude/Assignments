package com.acabes.assignments.java.flightbooking;

interface BookingSystem {
    void bookFlight(int flightNumber);

    void cancelFlight(int flightNumber, int bookindId);

    void displaySeatAvailability();
}