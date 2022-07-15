package edu.freeit.lesson5;

import java.util.Random;

// Создать массив оценок произвольной длины,
// вывести максимальную и минимальную оценку, её (их) номера.
public class MaxAndMin {
    public static void main(String[] args) {
        Random random = new Random();
        int lenght = Math.abs(random.nextInt(21)) + 1;
        int[] numbers = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            numbers[i] = random.nextInt(10) + 1;
            System.out.print(numbers[i] + ", ");
        }
        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < lenght; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }
        System.out.println();
        System.out.println(" max element is " + max + ", index " + maxIndex);
        System.out.println(" min element is " + min + ", index " + minIndex);
    }
}
