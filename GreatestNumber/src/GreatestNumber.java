import java.util.Scanner;

public class GreatestNumber {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the three numbers");
        int firstNumber = userInput.nextInt();
        int secondNumber = userInput.nextInt();
        int thirdNumber = userInput.nextInt();

        if(firstNumber > secondNumber && firstNumber > thirdNumber) {
            System.out.println(firstNumber + " is the greatest");
        }
        else if(secondNumber > thirdNumber){
            System.out.println(secondNumber + " is the greatest");
        }
        else{
            System.out.println(thirdNumber + " is the greatest");
        }
    }
}
