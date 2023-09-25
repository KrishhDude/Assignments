public class Student {
    private String studentId;
    private String studentName;
    private int studentClass;
    private int totalMarks;

    Student(String studentId, String studentName, int studentClass, int totalMarks){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.totalMarks = totalMarks;
    }
    static char calculateGrade(int totalMarks){
        if(totalMarks>=90 && totalMarks<=100)
            return 'A';
        else if(totalMarks>=80)
            return 'B';
        else if(totalMarks>=70)
            return 'C';
        else if(totalMarks>=60)
            return 'D';
        else
            return 'F';
    }
    void displayStudentInfo(){
        System.out.println("Student Id: " + this.studentId);
        System.out.println(" Name: " + this.studentName);
        System.out.println(" Class: " + this.studentClass);
        System.out.println(" Marks: " + this.totalMarks);
        System.out.println(" Grade: "+ calculateGrade(totalMarks));
    }
}
