import java.util.Scanner;

public class PasswordChecker {

    static boolean isStrongPassword(String password) {
        char[] passArray = password.toCharArray();
        boolean flag=false;
        if(passArray.length<8){
            return false;
        }
        for(char z:passArray){
            if(Character.isUpperCase(z) || Character.isDigit(z))
                flag=true;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println(isStrongPassword(password));
    }
}
