import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NumberGuesser {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for me to guess:");
        int guess = sc.nextInt();

        System.out.println("Your Number is.........  ");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Guessing....");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(guess + "!!!!!!");
    }
}
