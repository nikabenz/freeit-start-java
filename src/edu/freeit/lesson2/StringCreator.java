package edu.freeit.lesson2;

import java.util.Scanner;

public class StringCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your text for string ");
        String text = scanner.nextLine();
        String str1 = createFromLiteral(text);
        String str2 = createFromNew(text);
        String str3 = str1 + str2;
        String str4 = args[0];
        String str5 = str4.substring(1);
    }
    private static String createFromLiteral(String literal) {
        return literal;
    }
    private static String createFromNew(String text) {
        return new String(text);
    }
}
