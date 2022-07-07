package edu.freeit.lesson5;
// Задача 3 из методички:
// Имеется 4500 секунд.
// Вывести в консоль содержащихся в этом количестве секунд:
// А) минут + секунд,
// В) часов + минут + секунд,
// С) дней + часов + минут + секунд,
// D) недель + дней + часов + минут + секунд.
// По аналогии с примером из методички.
public class TimePrinter {
    public static void main(String[] args) {
        int unit = 60;
        int secondsPerHour = unit * unit;
        int hoursPerDay = 24;
        int daysPerWeek = 7;
        int seconds = 5388678;
        System.out.printf(" А) минут + секунд: %d min %d sec \n", seconds / unit,  seconds % unit );
        System.out.printf(" В) часов + минут + секунд: %d h %d min %d sec \n",
                seconds / secondsPerHour,  (seconds % secondsPerHour) / unit, seconds % unit );
        System.out.printf(" С) дней + часов + минут + секунд: %d days %d h %d min %d sec \n",
                seconds / (secondsPerHour * hoursPerDay), (seconds % (secondsPerHour * hoursPerDay)) / secondsPerHour,
                (seconds % secondsPerHour) / unit, seconds % unit );
        System.out.printf(" D) недель + дней + часов + минут + секунд: %d weeks %d days %d h %d min %d sec ",
                seconds / (secondsPerHour * hoursPerDay * daysPerWeek),
                (seconds % (secondsPerHour * hoursPerDay * daysPerWeek)) / (secondsPerHour * hoursPerDay),
                ((seconds % (secondsPerHour * hoursPerDay * daysPerWeek)) % (secondsPerHour * hoursPerDay)) / secondsPerHour,
                (seconds % secondsPerHour) / unit, seconds % unit );
    }
}
