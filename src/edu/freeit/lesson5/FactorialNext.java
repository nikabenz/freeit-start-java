package edu.freeit.lesson5;

import java.util.Scanner;

// Посчитать факториал числа
// в границах от 10 до 15
// (не используя рекурсию).
public class FactorialNext {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println(" enter the number greater than 10 and less than 15: ");
        do {
            x = scanner.nextInt();
            if (x <= 10) {
                System.out.println(" its not possible, enter the number greater than 10: ");
            }
            if (x >= 15) {
                System.out.println(" its not possible, enter the number less than 15: ");
            }
        } while (x <= 10 || x >= 15);
        int factorial = 1;
        for (int i = 2; i <= x; i++) {
            factorial *= i;
        }
        System.out.println(x + "! = " + factorial);
        scanner.close();
    }
}
