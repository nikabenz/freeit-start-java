package edu.freeit.lesson4.addex;

public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder sb = arithmeticalStringBuilder(45, 67);
        System.out.println(sb);
        System.out.println(changeFromTo(sb, "=", "eq"));
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

    public static StringBuilder changeFromTo(StringBuilder result, String from, String to) {
        int index;
        while ((index = result.indexOf(from)) != -1) {
            result.deleteCharAt(index);
            result.insert(index, to);
        }
        return result;
    }
}
