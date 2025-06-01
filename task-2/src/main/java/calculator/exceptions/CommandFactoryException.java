package calculator.exceptions;

public class CommandFactoryException extends CalculatorException {
    public CommandFactoryException(String message) {
        super("Command factory exception: " + message);
    }
}
