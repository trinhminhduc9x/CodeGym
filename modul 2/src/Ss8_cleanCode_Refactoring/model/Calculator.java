package Ss8_cleanCode_Refactoring.model;

public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static int calculate(int FirstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return FirstOperand + secondOperand;
            case SUBTRACTION:
                return FirstOperand - secondOperand;
            case MULTIPLICATION:
                return FirstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return FirstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
