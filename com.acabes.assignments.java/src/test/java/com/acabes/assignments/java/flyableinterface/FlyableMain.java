package com.acabes.assignments.java.flyableinterface;

interface Flyable{
    abstract void fly_obj();
}

class SpaceCraft implements Flyable{
    public void fly_obj(){
        System.out.println("I am a spacecraft!");
    }
}

class Airplane implements Flyable{
    public void fly_obj(){
        System.out.println("I am an airplane");
    }
}

class Helicopter implements Flyable{
    public void fly_obj(){
        System.out.println("I am a helicopter");
    }
}

public class FlyableMain {
    public static void main(String[] args) {
        SpaceCraft spacecraft = new SpaceCraft();
        Airplane airplane = new Airplane();
        Helicopter helicopter = new Helicopter();

        spacecraft.fly_obj();
        airplane.fly_obj();
        helicopter.fly_obj();
    }
}
