package calculator.exceptions;

public class CommandException extends CalculatorException {
    public CommandException(String message) {
        super("Command exception: " + message);
    }
}
