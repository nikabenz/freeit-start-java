package edu.freeit.lesson5;

import java.util.Scanner;
import static java.lang.Math.pow;

// Определить число, полученное выписыванием в обратном порядке
// цифр любого 4-х значного натурального числа n
public class NumberFromReverseDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 9; // n - значность числа можно менять
        System.out.print("enter " + length + "-digit number to reverse ");
        int ten = 10;
        int[] digits = new int[length];
        int number = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            digits[i] = number % ten;
            number /= ten;
        }
        int j = length - 1;
        int result = 0;
        for (int i = 0; i < length ; i++) {
            result += digits[i]*pow(ten, j--);
        }
        System.out.print("result " + result);
        scanner.close();
    }
}
