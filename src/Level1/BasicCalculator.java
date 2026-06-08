package Level1;

import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1;
        double number2;
        char operator;
        double result = 0;
        boolean validOperation = true;

        System.out.print("Enter number1: ");
        number1 = scanner.nextDouble();

        System.out.print("Enter operator + - * / ^: ");
        operator = scanner.next().charAt(0);

        System.out.print("Enter number2: ");
        number2 = scanner.nextDouble();

        switch (operator) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> {
                if (number2 == 0) {
                    System.out.print("Can't be divided by 0");
                    validOperation = false;
                } else {
                    result = number1 / number2;
                }
            }
            case '^' -> result = Math.pow(number1, number2);
            default -> {
                System.out.print("Invalid Operator");
                validOperation = false;
            }
        }

        if (validOperation) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
};