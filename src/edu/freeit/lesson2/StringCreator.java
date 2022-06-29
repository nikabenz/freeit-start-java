package edu.freeit.lesson2;

import java.util.Scanner;

public class StringCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your text for string ");
        String text = scanner.nextLine();
        String str1 = "Its literal here ";
        String str2 = new String(text);
        String str3 = str1 + str2;
        System.out.println("creating string from concatenation: " + str3);
        String str4 = args[0];
        String str5 = str1.substring(1);
        System.out.println("creating string from substring: " + str5);
    }
}
