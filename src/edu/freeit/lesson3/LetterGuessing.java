package edu.freeit.lesson3;

import java.util.Scanner;

//сравниваю его два шага:
//удаляется(chilly)-приближается(warmly) и
//насколько(hot - рядом, в радиусе двух букв; cold - удалён на десять и более))
public class LetterGuessing {
    final static char[] LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user;
        do {
            getResult(scanner);
            System.out.println("do you want to play again? y/no ");
            user = scanner.nextLine();
        } while (!user.equals("no"));
        System.out.println("game over ");
        scanner.close();
    }

    private static void getResult(Scanner scanner) {
        int trueIndex = 0;
        int myIndex = 0;
        int step = 0;
        int nextStep;
        char letter;
        final char guess = LETTERS[(int) (Math.random() * 26)];
        for (int j = 0; j < LETTERS.length; j++) {
            if (guess == LETTERS[j]) {
                trueIndex = j;
                break;
            }
        }
        System.out.println("guess the letter: ");
        letter = scanner.nextLine().charAt(0);
        if (letter == guess) {
            System.out.println("bingo");
            return;
        }
        myIndex = defineMyIndex(letter);
        step = Math.abs(trueIndex - myIndex);
        if (step <= 2) {
            System.out.print("hot, ");
        } else if (step >= 10) {
            System.out.print("cold, ");
        } else {
            System.out.print("chilly, ");
        }
        System.out.println("try again ");
        letter = scanner.nextLine().charAt(0);
        while (letter != '*') {
            if (letter == guess) {
                System.out.println("bingo");
                return;
            }
            myIndex = defineMyIndex(letter);
            nextStep = Math.abs(trueIndex - myIndex);
            if (nextStep > step) {
                if (nextStep >= 10) {
                    System.out.println("cold");
                } else {
                    System.out.println("chilly");
                }
            } else {
                if (nextStep <= 2) {
                    System.out.println("hot");
                } else {
                    System.out.println("warmly");
                }
            }
            step = nextStep;
            System.out.println(" try again? no - *");
            letter = scanner.nextLine().charAt(0);
        }
        System.out.println("fail");
        System.out.println("you didn't guess -> " + guess);
    }

    public static int defineMyIndex(char letter) {
        int myIndex = 0;
        for (int i = 0; i < LETTERS.length; i++) {
            if (letter == LETTERS[i]) {
                myIndex = i;
                break;
            }
        }
        return myIndex;
    }
}