import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public double performOperation(double num1, double num2, String operation) {
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    result = num1 / num2;
                }
                break;
            case "%":
                result = num1 % num2;
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
            case "sqrt":
                if (num1 <= 0) {
                    System.out.println("Cannot calculate square root of a negative number");
                    break;
                } else {
                    result = Math.sqrt(num1);
                }
                break;
            default:
                System.out.println("Invalid operation");
        }
        return result;
    }

    public static void main(String[] args) {
        double num1, num2;
        String operation;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the operation (+, -, *, /, %, ^, sqrt) or 'exit' to quit: ");
            operation = input.next();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                System.out.println("Enter the first number: ");
                num1 = input.nextDouble();

                if  (operation.equals("sqrt")) {
                    num2 = 0;
                } else {
                    System.out.println("Enter the second number: ");
                    num2 = input.nextDouble();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }

            Calculator calculator = new Calculator();
            double result = calculator.performOperation(num1, num2, operation);
            System.out.println("Result: " + result);

            System.out.println("Do you want to continue? (yes/no)");
            String answer = input.next();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }
        input.close();
    }
}
