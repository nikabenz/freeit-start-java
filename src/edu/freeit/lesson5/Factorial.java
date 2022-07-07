package edu.freeit.lesson5;

import java.math.BigInteger;
import java.util.Scanner;

//  факториал числа
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        BigInteger bigIntegerResult = BigInteger.ONE;
        for (long i = 2; i <= x; i++) {
            bigIntegerResult = bigIntegerResult.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigIntegerResult);
        scanner.close();
    }
}
