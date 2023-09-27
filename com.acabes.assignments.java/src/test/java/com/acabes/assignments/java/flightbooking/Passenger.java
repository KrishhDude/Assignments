package com.acabes.assignments.java.flightbooking;

class Passenger implements BookingSystem{

    Flight[] flights = {
            new Flight(1001),
            new Flight(1002),
            new Flight(1003)
    };

    public void getFlight(){
        for(Flight flight: flights){
            System.out.println(flight.flightNumber + "\n");
        }
    }

    public void bookFlight(int flightNumber) {
        System.out.println("hi");
    }

    public void cancelFlight() {

    }

    public void displaySeatAvailability() {

    }

}