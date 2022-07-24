package edu.freeit.lesson7;

import com.sun.source.tree.PatternTree;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println(string.substring(7, 11));
        char[] operations = new char[]{'+', '-', '*'};
        int firstOperand = 6;
        int secondOperand = 26;
        StringBuilder[] results = new StringBuilder[3];

        for (int i = 0; i < results.length; i++) {
            results[i] = new StringBuilder()
                    .append(firstOperand)
                    .append(operations[i])
                    .append(secondOperand)
                    .append(" = ");
        }
        StringBuilder[] eqs = new StringBuilder[]{new StringBuilder().append(firstOperand + secondOperand),
                new StringBuilder().append(firstOperand - secondOperand),
                new StringBuilder().append(firstOperand * secondOperand)};
        StringBuilder[] sb = new StringBuilder[3];
        for (int i = 0; i < results.length; i++) {
            sb[i] = new StringBuilder(results[i].append(eqs[i]));
        }
        int index = new StringBuilder(sb[0]).indexOf("=");
        for (int i = 0; i < results.length; i++) {

            sb[i].deleteCharAt(index).insert(index, "равно");

            System.out.println(sb[i].toString());
        }
        String source = "Object-oriented programming is a programming language model organized around objects " +
                "rather than \"actions\" and data rather than logic. Object-oriented programming blabla. " +
                "Object-oriented programming bla.";
        //changeToOOP(source);
        //System.out.println(doOOP(source));
        System.out.println(Arrays.toString(takeTwoLettersFromMiddle("er","erro","practice","hero","lesson")));
    }

    public static void changeToOOP(String source) {
        Pattern pattern = Pattern.compile("Object-oriented programming");
        Matcher matcher = pattern.matcher(source);
        int i = 0;
        while (true) {
            if (matcher.find()) {
                i++;
                System.out.println(matcher.group().lastIndexOf("Object-oriented programming"));
                //.replaceAll("Object-oriented programming", "OOP"));
                System.out.println(i);
            } else {
                break;
            }
        }
    }


    public static String doOOP(String source) {
        StringBuilder stringBuilder = new StringBuilder(source);
        int startIndex;
        int finishIndex;
        Pattern pattern = Pattern.compile("Object-oriented programming");
        Matcher matcher = pattern.matcher(stringBuilder);
        int i = 0;
        while (matcher.find()) {
            i++;
            if (i % 2 == 0) {
                for (int j = 0; j < "Object-oriented programming".length(); j++) {
                }
                System.out.println(matcher.group().replaceAll("Object-oriented programming", "OOP"));
            }
        }
        System.out.println("index " + i);
        for (int j = 0; j < i; j++) {
            if (i % 2 == 0) {
            }
        }
        return stringBuilder.toString();
    }
    public static String[] takeTwoLettersFromMiddle(String... words) {
        String[] lettersFromMiddle = new String[words.length];
        int startIndex;
        int endIndex;
        for (int i = 0; i < words.length; i++) {
            startIndex = (words[i].length() / 2) - 1;
            endIndex = startIndex + 2;
            lettersFromMiddle[i] = words[i].substring(startIndex, endIndex);
        }
        return  lettersFromMiddle;
    }
}
