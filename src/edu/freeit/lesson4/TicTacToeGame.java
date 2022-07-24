package edu.freeit.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// у человека всегда О, Х выставляется рандомно
public class TicTacToeGame {
    public static char ticTacToeWinner = ' ';
    public static int length = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[length][length];
        int[] step;
        int x;
        int y;
        int counter = 0;
        cleanField(field);
        int maxCountOfSteps = length * length;
        do {
            step = calculateStep(field);
            x = step[0];
            y = step[1];
            outputField('X', x, y, field);
            if (defineWinner('X', x, y, field)) {
                break;
            }
            counter++;
            if (counter == maxCountOfSteps) {
                break;
            }
            System.out.println(" your turn: \n");
            x = scanner.nextInt();
            y = scanner.nextInt();
            outputField('O', x, y, field);
            if (defineWinner('O', x, y, field)) {
                break;
            }
            counter++;
            if (counter == maxCountOfSteps) {
                break;
            }
        } while (true);
        if (ticTacToeWinner != ' ') {
            System.out.println("winner is " + ticTacToeWinner);
        } else {
            System.out.println("its no winners in this game, sorry... ");
        }
        System.out.println("game over ");
        scanner.close();
    }

    public static void cleanField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], ' ');
        }
    }

    public static void outputField(char playerStep, int x, int y, char[][] field) {
        if (field[x][y] != ' ') {
            System.out.println("wrong step, try again ");
            return;
        }
        field[x][y] = playerStep;
        String border;
        if (length == 3) {
            border = "_".repeat(19);
        } else {
            border = "_".repeat(19 + (length - 3) * 6);
        }
        System.out.println(border);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == field[i].length - 1) {
                    System.out.printf("|  %1s  |", field[i][j]);
                    System.out.println();
                } else {
                    System.out.printf("|  %1s  ", field[i][j]);
                }
            }
            System.out.println(border);
        }
    }

    public static int[] calculateStep(char[][] field) {
        int[] step = new int[2];
        Random random = new Random();
        do {
            step[0] = random.nextInt(length);
            step[1] = random.nextInt(length);
        } while (field[step[0]][step[1]] != ' ');
        return step;
    }

    public static boolean defineWinner(char playerStep, int x, int y, char[][] field) {
        int winner = 0;
        for (int i = 0; i < length; i++) {
            if (field[i][i] == playerStep) {
                winner++;
            }
        }
        if (winner == length) {
            ticTacToeWinner = field[0][0];
            return true;
        }
        winner = 0;
        for (int i = 0; i < length; i++) {
            if (field[length - 1 - i][i] == playerStep) {
                winner++;
            }
        }
        if (winner == length) {
            ticTacToeWinner = field[length - 1][0];
            return true;
        }
        winner = 0;
        for (int j = 0; j < length; j++) {
            if (field[x][j] == playerStep) {
                winner++;
            }
        }
        if (winner == length) {
            ticTacToeWinner = playerStep;
            return true;
        }
        winner = 0;
        for (int i = 0; i < length; i++) {
            if (field[i][y] == playerStep) {
                winner++;
            }
        }
        if (winner == length) {
            ticTacToeWinner = playerStep;
            return true;
        }
        return false;
    }
}
