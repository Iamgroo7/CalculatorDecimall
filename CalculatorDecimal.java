import java.util.Scanner;

public class CalculatorDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        boolean firstCalculation = true;

        System.out.println("Welcome to the Calculator Program!");
        System.out.println("You can use the previous result in the next calculation by typing 'r'.");

        while (true) {
            System.out.print("Enter the first number (or 'r' for previous result): ");
            double num1;
            if (firstCalculation || !scanner.hasNext("r")) {
                num1 = scanner.hasNextDouble() ? scanner.nextDouble() : result;
                firstCalculation = false;
            } else {
                scanner.next(); // consume 'r'
                num1 = result;
            }

            System.out.print("Enter an operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");
                    continue;
            }

            System.out.println("Result: " + result);
            displayInFormats(result);

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    private static void displayInFormats(double number) {
        int intValue = (int) number;
        System.out.println("Decimal: " + number);
        System.out.println("Octal: " + Integer.toOctalString(intValue));
        System.out.println("Hexadecimal: " + Integer.toHexString(intValue));
        System.out.println("Binary: " + Integer.toBinaryString(intValue));
    }
}
