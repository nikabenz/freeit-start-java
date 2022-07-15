package edu.freeit.lesson5;

import java.util.Scanner;

// Имеется целое число,
// определить является ли это число простым,
// т.е. делится без остатка только на 1 и себя.
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        x = Math.abs(x);
        int marker = 0;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                marker++;
            }
        }
        if (marker == 0) {
            System.out.println(x + " is a prime number ");
        } else {
            System.out.println(x + " is not a prime number ");
        }
        scanner.close();
    }
}
