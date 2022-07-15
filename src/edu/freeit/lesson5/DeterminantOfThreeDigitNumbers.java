package edu.freeit.lesson5;
// Создайте число.
// Определите, является ли число трехзначным.
// Определите, является ли его последняя цифра семеркой.
// Определите, является ли число четным.
import java.util.Scanner;

public class DeterminantOfThreeDigitNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number ");
        int number = scanner.nextInt();
        int ten = 10;
        int hundred = 100;
        int thousand = 1000;
        int lastDigit = 7;
        int two = 2;
        if (number / thousand == 0 && number / hundred != 0) {
            System.out.println(" its a three-digits number ");
        } else {
            System.out.println(" it is not a three-digits number ");
        }
        if (number % ten == lastDigit) {
            System.out.println(" last digit is seven ");
        } else {
            System.out.println(" last digit is not seven ");
        }
        if (number % two == 0) {
            System.out.println(" it is an even number ");
        } else {
            System.out.println(" it is not an even number ");
        }
        scanner.close();
    }
}
