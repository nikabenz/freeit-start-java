package edu.freeit.lesson4.addex;

import java.util.Arrays;

public class StrStrBuilderBufferEx {
    public static void main(String[] args) {
        String string = "I like Java!!!";
        System.out.println(string.charAt(string.length() - 1));
        System.out.println(string.endsWith("!!!"));
        System.out.println(string.startsWith("I like"));
        System.out.println(string.contains("Java"));
        System.out.println(string.indexOf("Java"));
        System.out.println(string.replace("a", "o"));
        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());
        String java = "Java";
        int indexFrom = string.indexOf(java.charAt(0));
        System.out.println(string.substring(indexFrom, indexFrom + java.length()));
        int firstOperand = 6;
        int secondOperand = 26;
        char[] operations = new char[]{'+', '-', '*', '='};
        int[] equals = new int[]{firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};
        StringBuilder[] results = new StringBuilder[3];

        for (int i = 0; i < results.length; i++) {
            results[i] = new StringBuilder()
                    .append(firstOperand)
                    .append(operations[i])
                    .append(secondOperand)
                    .append(operations[operations.length - 1]).append(equals[i]);
            int index = results[i].indexOf("=");
            System.out.println(results[i].toString());
            results[i].deleteCharAt(index).insert(index, " равно ");
            System.out.println(results[i].toString());
        }
        System.out.println(Arrays.toString(takeTwoLettersFromMiddle("er", "erro", "practice", "hero", "lesson", "string", "code", "matter")));
    }

    public static String[] takeTwoLettersFromMiddle(String... words) {
        String[] lettersFromMiddle = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            int indexFrom = (words[i].length() / 2) - 1;
            lettersFromMiddle[i] = words[i].substring(indexFrom, indexFrom + 2);
        }
        return lettersFromMiddle;
    }
}
