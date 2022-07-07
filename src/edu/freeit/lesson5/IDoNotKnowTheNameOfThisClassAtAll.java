package edu.freeit.lesson5;

import java.util.Random;

import static java.lang.String.join;

// Имеется целое число
// (задать с помощью Random rand = new Random(); int x = rand.nextInt() ).
// Это число – количество денег в рублях.
// Вывести это число, добавив к нему слово «рублей» в правильном падеже.
public class IDoNotKnowTheNameOfThisClassAtAll {
    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt();
        System.out.println(x + define(Math.abs(x)));
    }

    public static String define(int x) {
        String result = "";
        int ten = 10;
        int hundred = 100;
        int[] digitTeen = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        for (int i = 0; i < digitTeen.length; i++) {
            if (x % hundred == digitTeen[i]) {
                result = " рублей";
                return result;
            }
        }
        if (x % ten == 1) {
            result = " рубль";
            return result;
        } else if (x % ten == 2 || x % ten == 3 || x % ten == 4) {
            result = " рубля";
            return result;
        } else {
            result = " рублей";
            return result;
        }
    }
}
