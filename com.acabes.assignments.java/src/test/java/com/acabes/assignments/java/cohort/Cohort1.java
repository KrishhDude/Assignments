package com.acabes.assignments.java.cohort;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

class Cohort1 {
    String name;
    int age;
    String city;
    Date dateOfBirth;

    public Cohort1(String name, int age, String city, Date dateOfBirth) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
