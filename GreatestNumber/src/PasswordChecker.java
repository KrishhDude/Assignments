import java.util.Scanner;

public class PasswordChecker {

    public static  boolean isStrongPassword(String password){
        boolean passLength=false,containUpper=false,containLower =false,containDigit =false;
        char[] charPassword = password.toCharArray();
        if(charPassword.length>=8){
            passLength=true;
        }
        for (int i = 0; i <charPassword.length ; i++) {
            if(Character.isLowerCase((charPassword[i])) && !containLower){
                containLower = true;
            }
            if(Character.isUpperCase((charPassword[i])) && !containUpper){
                containUpper = true;
            }
            if(Character.isDigit(charPassword[i]) && !containDigit){
                containDigit = true;
            }
        }
        return  passLength && containLower && containUpper && containDigit;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag){
            System.out.println("Enter Password");
            String pass = sc.next();
            if(isStrongPassword(pass)){
                System.out.println("Password Valid");
                flag=false;
            }else {
                System.out.println("Not a valid password");
            }
        }

    }

}