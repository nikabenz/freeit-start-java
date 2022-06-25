package edu.freeit.lesson2;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.nextLine();
        System.out.println("enter your gender: ");
        String gender = scanner.nextLine();
        System.out.println("enter your age: ");
        int age = scanner.nextInt();
        System.out.println(getGreetings(name, gender, age));
    }
    private static String getGreetings(String name, String gender, int age) {
        String greetings;
        String ending = "!";
        if (age >= 45) {
            greetings = gender.equals("female")? "Hello, madam " : "Hello, mister ";
        } else if (age >= 30) {
            greetings = gender.equals("female")? "Hello, lady " : "Hello, gentleman ";
        } else if (age >= 18) {
            greetings = "Hi, ";
        } else if (age >= 13) {
            greetings = "Yo, ";
        } else {
            greetings = "Hey, howdy hi, ";
        }
        return greetings + name + ending;
    }
}
