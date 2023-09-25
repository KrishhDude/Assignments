import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char choice;
        do{
            System.out.println("Enter the student's ID: ");
            String studentId = sc.nextLine();
            System.out.println("Enter Name: ");
            String studentName = sc.nextLine();
            System.out.println("Enter student's class: ");
            int studentClass = sc.nextInt();
            System.out.println("Enter total marks: ");
            int totalMarks = sc.nextInt();

            Student student = new Student(studentId, studentName, studentClass, totalMarks);
            //System.out.println(student.calculateGrade(totalMarks));
            student.displayStudentInfo();

            System.out.println("\nDo you want to continue adding details: (y or n)");
            choice = sc.next().charAt(0);
        }while(choice=='y');
    }
}
