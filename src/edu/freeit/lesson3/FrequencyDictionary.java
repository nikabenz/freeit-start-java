package edu.freeit.lesson3;

import java.util.Scanner;
//в частотном словарике используется на вход строка со словами,
//разделёнными пробелом, никаких знаков
public class FrequencyDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println(getFrequency(sentence));
    }
    private static String getFrequency(String sentence) {
        String[] words = sentence.split(" ");
        String frequency = "";
        int n;
        for (int i = 0; i < words.length; i++) {
            n = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]) & !words[i].equals("*")) {
                    words[j] = "*";
                    n++;
                }
            }
            if (!words[i].equals("*")) {
                frequency += words[i] + " -> " + n + "\n";
            }
        }
        return frequency;
    }
}
