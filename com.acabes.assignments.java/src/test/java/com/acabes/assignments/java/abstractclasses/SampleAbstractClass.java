package com.acabes.assignments.java.abstractclasses;

abstract class SampleAbstractClass {
    SampleAbstractClass(){
        System.out.println("This is the constructor of abstract class");
    }
    public abstract void aMethod();

    public void nonAbstractMethod(){
        System.out.println("This is a normal method of abstract class");
    }
}
