package edu.freeit.lesson4.addex;

import java.util.Arrays;

public class StrStrBuilderBufferEx {
    public static void main(String[] args) {
        String string = "I like Java!!!";
        String source = "Я каждый день учу, учу, учу, учу, учу, учу, учу, учу Java!!!!";
        System.out.println(source.replaceAll(" учу,", ""));
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
        String src = "Object-oriented programming is a programming language model organized around objects " +
                "rather than \"actions\" and data rather than logic. Object-oriented programming blabla. " +
                "Object-oriented programming bla. Object-oriented programming bla. Object-oriented programming bla. " +
                "Object-oriented programming bla. Object-oriented programming bla. Object-oriented programming bla. " +
                "Object-oriented programming bla. Object-oriented programming bla. Object-oriented programming bla.";
        String from = "object-oriented programming";
        String to = "OOP";
        System.out.println(allChangeFromTo(new StringBuilder(src.toLowerCase()), from, to));
        System.out.println(changeFromTo(new StringBuilder(src.toLowerCase()), from, to));
        System.out.println(Arrays.toString(takeTwoLettersFromMiddle(
                "er", "erro", "practice", "hero", "lesson", "string", "code", "matter")));
    }

    public static String[] takeTwoLettersFromMiddle(String... words) {
        String[] lettersFromMiddle = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            int indexFrom = (words[i].length() / 2) - 1;
            lettersFromMiddle[i] = words[i].substring(indexFrom, indexFrom + 2);
        }
        return lettersFromMiddle;
    }

    public static StringBuilder allChangeFromTo(StringBuilder src, String from, String to) {
        int indexFrom;
        while ((indexFrom = src.indexOf(from)) != -1) {
            src.replace(indexFrom, indexFrom + from.length(), to);
        }
        return src;
    }

    public static StringBuilder changeFromTo(StringBuilder src, String from, String to) {
        int indexFrom = 0;
        while (true) {
            indexFrom = src.indexOf(from, from.length() + indexFrom);
            if (indexFrom != -1) {
                src.replace(indexFrom, indexFrom + from.length(), to);
            } else {
                break;
            }
        }
        return src;
    }
}
