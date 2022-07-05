package edu.freeit.lesson4;

import java.util.Scanner;
// Используются только самые простые знаки пунктуации
// В конце предложения могут быть ! ? . ... (один и больше)
// В тексте отдельного предложения могут быть : ; , ( ) - и пробел (один и больше)
// В storage, двумерном массиве, сохранены в каждом элементе
// предложение и его частотный перечень слов, что подтверждает вывод
public class FrequencyDictionaryForText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your text: ");
        String text = scanner.nextLine();
        System.out.println("output dictionary: ");
        outputDictionary(prepareDataForStorage(text));
        scanner.close();
    }
    public static void outputDictionary(String[][] storage) {
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                System.out.printf("%s ", storage[i][j]);
                System.out.println();
            }
            System.out.println();
        }
    }
    public static String[][] prepareDataForStorage(String text) {
        String[] sentences = text.split("[!?.]+");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
        }
        String[][] preparingDataForStorage = new String[sentences.length][];
        for (int i = 0; i < sentences.length; i++) {
            preparingDataForStorage[i] = new String[sentences[i].split("[\" \",:;\\-()]+").length];
            String[] words = sentences[i].split("[\" \",:;\\-()]+");
            for (int j = 0; j < preparingDataForStorage[i].length; j++) {
                preparingDataForStorage[i][j] = words[j].trim();
            }
        }
        String[][] storage = new String[sentences.length][2];
        for (int j = 0; j < storage.length; j++) {
            storage[j][0] = sentences[j];
            storage[j][1] = getFrequency(preparingDataForStorage[j]);
        }
        return storage;
    }
    public static String getFrequency(String[] words) {
        String frequency = "";
        int n;
        for (int i = 0; i < words.length; i++) {
            n = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]) && !words[i].equals("*")) {
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
