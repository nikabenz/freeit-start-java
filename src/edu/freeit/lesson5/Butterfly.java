package edu.freeit.lesson5;

import java.util.Random;

// Создать двухмерный квадратный массив,
// и заполнить его «бабочкой»
public class Butterfly {
    public static void main(String[] args) {
        output(fill(create()));
    }
    public static int[][] create() {
        Random random = new Random();
        int length;
        do {
            length = Math.abs(random.nextInt(20) + 1);
        } while (length % 2 != 1);
        int[][] butterfly = new  int[length][length];
        for (int i = 0; i < butterfly.length; i++) {
            for (int j = 0; j < butterfly[i].length; j++) {
                butterfly[i][j] = 1;
            }
        }
        int size = length / 2;
        for (int  i = 0;  i < length;  i++) {
            if (i != size) {
                butterfly[size][i] = 0;
            } else {
                continue;
            }
        }
        return  butterfly;
    }
    public static void output(int[][] butterfly) {
        for (int i = 0; i < butterfly.length; i++) {
            for (int j = 0; j < butterfly[i].length; j++) {
                System.out.print(butterfly[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] fill(int[][] butterfly) {
        int length = butterfly.length;
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            for (int j = i + 1; j < halfLength; j++) {
                butterfly[j][i] = 0;
            }
        }
        for (int i = halfLength + 1; i < length; i++) {
            for (int j = length - i; j < halfLength; j++) {
                butterfly[j][i] = 0;
            }
        }
        for (int i = halfLength + 1; i < length; i++) {
            for (int j = 1 + i ; j < length; j++) {
                butterfly[i][j] = 0;
            }
        }
        for (int i = halfLength + 1; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                butterfly[i][j] = 0;
            }
        }
        return  butterfly;
    }
}
