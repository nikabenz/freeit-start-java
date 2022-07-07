package edu.freeit.lesson5;

import java.util.Random;

// Создать последовательность случайных чисел,
// найти и вывести наибольшее из них.
public class MaxNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int lenght = Math.abs(random.nextInt(11)) + 1;
        int[] numbers = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            numbers[i] = random.nextInt(20);
            System.out.print(numbers[i] + ", ");
        }
        int max = numbers[0];
        for (int i = 0; i < lenght; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(" max element is " + max);
    }
}
