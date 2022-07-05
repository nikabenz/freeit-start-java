package edu.freeit.lesson4;

import java.util.Random;
import java.util.Scanner;
// у человека всегда О, Х выставляется рандомно
// так как выхода из цикла do-while в main вообще нет
// (зациклены два хода, рандомный и ручной ввод, два вывода поля field),
// то, чтоб не вылететь, приходится тупо следовать инструкции, такой же тупой.
// Чтоб ввести индексы ячейки двумерного массива для помещения туда своего О,
// приходится выбрать @
// !!!И при наступлении выйгрышной ситуации нажать (по запросу) вместо @ уже *
// странно, что не попросили два раза притопнуть и пять раз прихлопнуть((((((
public class TicTacToeGame {
    public static char ticTacToeWinner = ' ';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stopGame;
        char[][] field = new char[3][3];
        int[] step;
        int x;
        int y;
        cleanField(field);
        do {
            step = calculateStep(field);
            x = step[0];
            y = step[1];
            outputField('X', x, y, field);
            System.out.println(" yours turn -> @ or stop game -> *");
            stopGame = scanner.nextLine();
            if (stopGame.equals("*")) {
                defineWinner(field);
                break;
            }
            x = scanner.nextInt();
            y = scanner.nextInt();
            outputField('O', x, y, field);
            System.out.println(" yours turn -> @ or stop game -> *");
            stopGame = scanner.nextLine();
        } while (!stopGame.equals("*"));
        System.out.println(defineWinner(field));//здесь это для проверки
        System.out.println(ticTacToeWinner);//здесь это для проверки
        if (ticTacToeWinner != ' ') {
            System.out.println("winner is " + ticTacToeWinner);
        } else {
            System.out.println("its no winners in this game, sorry... ");
        }
        System.out.println("game over ");
        scanner.close();
    }

    public static void cleanField(char[][] field) {
        //Arrays.fill(field, ' ');
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public static void outputField(char playerStep, int x, int y, char[][] field) {
        if (field[x][y] != ' ') {
            System.out.println("wrong step, try again ");
            return;
        }
        field[x][y] = playerStep;
        System.out.println("___________________");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == field[i].length - 1) {
                    System.out.printf("|  %1s  |", field[i][j]);
                    System.out.println();
                } else {
                    System.out.printf("|  %1s  ", field[i][j]);
                }
            }
            System.out.println("-------------------");
        }
    }

    public static int[] calculateStep(char[][] field) {
        int[] step = new int[2];
        Random random = new Random();
        do {
            step[0] = random.nextInt(3);
            step[1] = random.nextInt(3);
        } while (field[step[0]][step[1]] != ' ');
        return step;
    }

    public static boolean defineWinner(char[][] field) {
        boolean winner = false;
        int win = 0;
        for (int i = 1; i < field.length; i++) {
            if (field[0][0] != field[i][i] && field[0][0] != ' ') {
                win++;
            }
        }
        if (win == 0) {
            winner = true;
            ticTacToeWinner = field[0][0];
            return winner;
        }
        win = 0;
        for (int i = 1; i < field.length; i++) {
            if (field[field.length - 1][0] != field[field.length - 1 - i][i] && field[field.length - 1][0] != ' ') {
                win++;
            }
        }
        if (win == 0) {
            winner = true;
            ticTacToeWinner = field[field.length - 1][0];
            return winner;
        }
        for (int i = 0; i < field.length; i++) {
            win = 0;
            for (int j = 1; j < field[i].length; j++) {
                if (field[0][i] != field[j][i] && field[0][i] != ' ') {
                    win++;
                }
            }
            if (win == 0) {
                winner = true;
                ticTacToeWinner = field[0][i];
                return winner;
            }
        }
        for (int i = 0; i < field.length; i++) {
            win = 0;
            for (int j = 1; j < field[i].length; j++) {
                if (field[i][0] != field[i][j] && field[i][0] != ' ') {
                    win++;
                }
            }
            if (win == 0) {
                winner = true;
                ticTacToeWinner = field[i][0];
                return winner;
            }
        }
        return winner;
    }
}
