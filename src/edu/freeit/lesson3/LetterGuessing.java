package edu.freeit.lesson3;

import java.util.Scanner;
//я не смогла организовать логику так, чтоб не дублировать код
//первые две попытки вслепую, чтоб начать ориентировать человека,
//сравнивая его два шага:
//удаляется(chilly)-приближается(warmly) и
//насколько(hot - рядом, в радиусе двух букв; cold - удалён на десять и более))
public class LetterGuessing {
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
        final String fail = "fail";
        final String bingo = "bingo";
        final String cold = "cold";
        final String chilly = "chilly";
        final String hot = "hot";
        final String warmly = "warmly";
        final char[] letters = {'a','b','c','d','e','f','g','h',
                          'i','j','k','l','m','n','o','p',
                          'q','r','s','t','u','v','w','x','y','z'};
        int trueIndex = 0;
        int myIndex = 0;
        int step = 0;
        int nextStep;
        char letter;
        final char guess = letters[(int) (Math.random()*26)];
        for (int j = 0; j < letters.length; j++) {
            if (guess == letters[j]) {
                trueIndex = j;
                break;
            }
        }
        System.out.println("guess the letter: ");
        letter = scanner.nextLine().charAt(0);
        if (letter == guess) {
            System.out.println(bingo);
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letter == letters[i]) {
                myIndex = i;
                break;
            }
        }
        step = Math.abs(trueIndex - myIndex);
        System.out.println("try again ");
        do {
            letter = scanner.nextLine().charAt(0);
            if (letter == guess) {
                System.out.println(bingo);
                return;
            }
            for (int i = 0; i < letters.length; i++) {
                if (letter == letters[i]) {
                    myIndex = i;
                    break;
                }
            }
            nextStep = Math.abs(trueIndex - myIndex);
            if (nextStep > step) {
                if (nextStep >= 10) {
                    System.out.println(cold);
                } else {
                    System.out.println(chilly);
                }
            } else {
                if (nextStep <= 2) {
                    System.out.println(hot);
                } else {
                    System.out.println(warmly);
                }
            }
            step = nextStep;
            System.out.println(" try again? no - *");
        } while (letter != '*');
        System.out.println(fail);
        System.out.println("you didn't guess -> " + guess);
    }
}
