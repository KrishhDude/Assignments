package com.acabes.assignments.java;

import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees: ");
        int limit = sc.nextInt();
        Employee[] emp = new Employee[limit];

        for (int i = 0; i < limit; i++) {
            System.out.println("Enter details of employee " + (i + 1));
            System.out.println("Enter ID:");
            String employeeId = sc.next();
            System.out.println("Enter name:");
            String employeeName = sc.next();
            System.out.println("Enter employee's monthly salary");
            double salary = sc.nextDouble();

            emp[i] = new Employee(employeeId, employeeName, salary);
        }
        for (int i = 0; i < limit; i++) {
            emp[i].displayEmployeeInfo();
        }
    }
}
