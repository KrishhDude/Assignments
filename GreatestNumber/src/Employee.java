public class Employee {
    private String employeeId;
    private String employeeName;
    private double salary;

    Employee(String employeeId, String employeeName, double salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }
    static void calculateAnnualSalary(double salary){
        System.out.println("Annual Salary: "+ salary*12);
    }
    void displayEmployeeInfo(){
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        calculateAnnualSalary(salary);

    }
}
