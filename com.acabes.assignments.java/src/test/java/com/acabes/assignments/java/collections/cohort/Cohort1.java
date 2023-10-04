package com.acabes.assignments.java.collections.cohort;

import java.util.Date;

class Cohort1 {
    private String name;
    private int age;
    private String city;
    private Date dateOfBirth;

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

    public java.lang.String getCity() {
        return city;
    }

    public Date getDob() {
        return dateOfBirth;
    }
}
