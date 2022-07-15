package edu.freeit.lesson5;

import java.util.Scanner;

// Имеется прямоугольное отверстие размерами a и b,
// определить, можно ли его полностью закрыть
// круглой картонкой с радиусом r.
public class AreaOfCircleAndRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" enter a, b, r: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();
        // по сути это проверка на то, что число 2r больше (не меньше, т.е. >=) каждого a и b одновременно
        int diameter = 2 * r;
        if (diameter >= a && diameter >= b) {
            System.out.println(" its possible ");
        } else {
            System.out.println(" its impossible ");
        }
        scanner.close();
    }
}
