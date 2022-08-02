package edu.freeit.lesson4.addex;

public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder sb = arithmeticalStringBuilder(45, 67);
        System.out.println(sb);
        System.out.println(change(sb));
    }

    public static StringBuilder arithmeticalStringBuilder(int firstOperand, int secondOperand) {
        StringBuilder result = new StringBuilder();
        result
                .append(firstOperand).append(" + ").append(secondOperand).append(" = ")
                .append(firstOperand + secondOperand).append("\n")
                .append(firstOperand).append(" - ").append(secondOperand).append(" = ")
                .append(firstOperand - secondOperand).append("\n")
                .append(firstOperand).append(" * ").append(secondOperand).append(" = ")
                .append(firstOperand * secondOperand).append("\n");
        return result;
    }

    public static StringBuilder change(StringBuilder result) {
        int index;
        while ((index = result.indexOf("=")) != -1) {
            result.deleteCharAt(index);
            result.insert(index, " equal ");
        }
        return result;
    }
}
