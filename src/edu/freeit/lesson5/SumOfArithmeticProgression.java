package edu.freeit.lesson5;

import java.util.Scanner;

// Найдите сумму первых n целых чисел,
// которые делятся на 3.
public class SumOfArithmeticProgression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        System.out.println(" sum of " + n + " first numbers (are divided into three) of the arithmetic progression is " + sum(n));
        scanner.close();
    }
    public static int sum(int n) {
        int first = 3;
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += first * i;
        }
        return sum;
    }
}
