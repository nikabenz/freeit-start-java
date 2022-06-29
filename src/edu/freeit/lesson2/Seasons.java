package edu.freeit.lesson2;

import java.util.Scanner;

public class Seasons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of month: ");
        int number = scanner.nextInt();
        System.out.println("month name is " + getMonth(number));
        System.out.println("season name is " + getSeason(number));
    }
    private static String getMonth(int number) {
        String[] monthName = {"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};
        if (number <= monthName.length) {
            return monthName[number - 1];
        } else {
            return "No such month";
        }
    }
    private static String getSeason(int number) {
        switch (number) {
            case 12, 1, 2 -> {
                return "Winter";
            }
            case 3, 4, 5 -> {
                return "Spring";
            }
            case 6, 7, 8 -> {
                return "Summer";
            }
            case 9, 10, 11 -> {
                return "Autumn";
            }
            default -> {
                return "nu such season";
            }
        }
    }
}
