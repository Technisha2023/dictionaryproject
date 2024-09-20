package testSamples;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number(1 to 500)");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] number = new int[n];
        Random random = new Random();


        int i;
        if (n < 1 || n > 500) System.out.println("Invalid Input, Please enter a number between 1 and 500");
        else
        System.out.println("Printing the Random Numbers");

        for ( i = 0; i < n; i++) {
            number[i] = random.nextInt(1000);
            System.out.println(number[i]);
        }
        System.out.println("Before sort : " +number[0]);
        Arrays.sort(number);
        System.out.println("The smallest number is : " + number[0]);
        scanner.close();
    }
}
