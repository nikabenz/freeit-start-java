package edu.freeit.lesson1;

import java.util.Scanner;

public class Comparing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        System.out.println("enter two numbers for comparing");
        System.out.println("first number is ");
        int first = scanner.nextInt();
        System.out.println("second number is ");
        int second = scanner.nextInt();
        if (first == second) {
            result = first + " = " + second;
        } else {
            result = first > second ? first + " > " + second : first + " < " + second;
        }
        System.out.println("result is " + result);
    }
}

