package edu.freeit.lesson5;
// Дано любое натуральное 4-х значное число. Верно ли, что все цифры числа различны?
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfDifferentDigits {
    public static int length = 9; // n - значность числа можно менять
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter " + length + "-digit number to define different digits ");
        int ten = 10;
        int[] digits = new int[length];
        int number = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            digits[i] = number % ten;
            number /= ten;
        }
        System.out.println(Arrays.toString(digits));
        define(digits);
        scanner.close();
    }
    public static void define(int[] digits) {
        int marker = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (digits[i] == digits[j] && i != j) {
                    marker++;
                }
            }
            if (marker != 0) {
                System.out.println("digits are not different ");
                return ;
            }

        }
        System.out.println("all digits are different ");
    }
}
