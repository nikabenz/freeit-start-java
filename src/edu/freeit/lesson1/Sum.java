package edu.freeit.lesson1;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter two numbers");
        System.out.print("first number is ");
        int first = scanner.nextInt();
        System.out.print("second numbers is ");
        int second = scanner.nextInt();
        System.out.println("sum is " + (first + second));
    }
}

