package edu.freeit.lesson5;

import java.util.Random;

// Определите сумму элементов одномерного массива,
// расположенных между минимальным и максимальным значениями.
public class SumElementsBetweenMinAndMax {
    public static void main(String[] args) {
        int[] array = create();
        System.out.println(output(array));
        System.out.println(" sum is " + defineSumOfElementsBetweenMinAndMax(array));
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
    public static int defineSumOfElementsBetweenMinAndMax(int[] array) {
        int sumOfElementsBetweenMinAndMax = 0;
        int max = array[0];
        int min = array[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        if (minIndex == maxIndex || Math.abs(minIndex - maxIndex) == 1) {
            sumOfElementsBetweenMinAndMax = 0;
        }
        if (maxIndex > minIndex) {
            for (int i = minIndex + 1; i < maxIndex; i++) {
                sumOfElementsBetweenMinAndMax += array[i];
            }
        } else {
            for (int i = maxIndex + 1; i < minIndex; i++) {
                sumOfElementsBetweenMinAndMax += array[i];
            }
        }
        return sumOfElementsBetweenMinAndMax;
    }
}
