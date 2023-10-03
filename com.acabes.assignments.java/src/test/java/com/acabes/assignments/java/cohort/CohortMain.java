package com.acabes.assignments.java.cohort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CohortMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Cohort1> cohort1List = new ArrayList<>();
        List<Cohort4> cohort4List = new ArrayList<>();
        addToCohort1(cohort1List);
        addToCohort4(cohort4List);
        System.out.println("Cohort 1");
        for(Cohort1 list : cohort1List){
            System.out.println("Name: " + list.name + "Age: " +  list.age + "City: " +
                                "City: " + list.city + "DOB: " + list.dateOfBirth);
        }

        System.out.println("Cohort 4");
        for(Cohort4 list : cohort4List){
            System.out.println("Name: " + list.name + "Age: " +  list.age + "City: " +
                    "City: " + list.city + "DOB: " + list.dateOfBirth);
        }



    }

    public static void addToCohort1(List<Cohort1> cohort1List){
        int numOfEmployees;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");

        System.out.println("How many employees would you like to add");
        Scanner sc = new Scanner(System.in);
        numOfEmployees = sc.nextInt();

        while (numOfEmployees>0) {
            System.out.println("Enter name: ");
            String name = sc.next();

            System.out.println("Enter age: ");
            int age = sc.nextInt();

            System.out.println("Enter city: ");
            String city = sc.next();

            System.out.println("Enter Date Of Birth (dd/mm/yy)");
            Date dateOfBirth = null;
            try {
                dateOfBirth = dateFormat.parse(sc.next());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Enter in dd/mm/yy format");
            }
            cohort1List.add(new Cohort1(name, age, city, dateOfBirth));
            numOfEmployees--;
        }

    }

    public static void addToCohort4(List<Cohort4> cohort4List){
        Date dateOfBirth = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
        try{
            Cohort4 [] cohort4Array = {
                    new Cohort4("Amal", 24, "Thrissur", dateFormat.parse("01/01/99")),
                    new Cohort4("Kp", 22, "Thrissur", dateFormat.parse("03/08/01")),
                    new Cohort4("Adithya", 23, "Thrissur", dateFormat.parse("01/01/00")),
                    new Cohort4("Fincy", 22, "Thrissur", dateFormat.parse("02/02/01")),
                    new Cohort4("Sanal", 21, "Thrissur", dateFormat.parse("03/06/02")),
            };
            cohort4List.addAll(Arrays.asList(cohort4Array));
        } catch (ParseException e){
            System.out.println("Invalid date format");
        }
    }

    public static void compareTwoCohorts(List<Cohort1> cohort1List, List<Cohort4> cohort4List){

        System.out.println("\nComparing ages from Cohort 1 and 4: ");
        for (Cohort1 cohort1 : cohort1List) {
            for (Cohort4 cohort4 : cohort4List) {
                if (cohort1.getAge() == cohort4.getAge()) {
                    System.out.println("Cohort1: " + cohort1.getName() + " Age: " + cohort1.getAge());
                    System.out.println("Cohort4: " + cohort4.getName() + " Age: " + cohort4.getAge());
                    System.out.println();
                }
            }
        }
    }
}
