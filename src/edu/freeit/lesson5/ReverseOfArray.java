package edu.freeit.lesson5;

import java.util.Arrays;
import java.util.Random;

// Создать массив, заполнить его случайными элементами,
// распечатать, перевернуть, и снова распечатать
// (при переворачивании нежелательно создавать еще один массив).
public class ReverseOfArray {
    public static void main(String[] args) {
        int[] array = create();
        System.out.println(output(array));
        System.out.println(output(reverse(array)));
    }
    public static String output(int[] array) {
        String arrayToString = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                arrayToString += array[i] + "\n";
            } else {
                arrayToString += array[i] + ", ";
            }
        }
        return arrayToString;
    }
    public static int[] reverse(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
    public static int[] create() {
        Random random = new Random();
        int length = random.nextInt(25) + 1;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(99);
        }
        return array;
    }
}
