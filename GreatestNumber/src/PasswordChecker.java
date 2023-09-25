import java.util.Scanner;

public class PasswordChecker {

    public static boolean isStrongPassword(String password) {
        boolean passLength = false, containUpper = false, containLower = false, containDigit = false;
        char[] charPassword = password.toCharArray();
        if (charPassword.length >= 8) {
            passLength = true;
        }
        for (char c : charPassword) {
            if (Character.isLowerCase(c) && !containLower) {
                containLower = true;
            }
            if (Character.isUpperCase(c) && !containUpper) {
                containUpper = true;
            }
            if (Character.isDigit(c) && !containDigit) {
                containDigit = true;
            }
        }
        return passLength && containLower && containUpper && containDigit;
    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Enter Password");
            String pass = sc.next();
            if (isStrongPassword(pass)) {
                System.out.println("Password Valid");
                flag = false;
            } else {
                System.out.println("Not a valid password");
            }
        }

    }

}