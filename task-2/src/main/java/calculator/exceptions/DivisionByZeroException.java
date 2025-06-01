package calculator.exceptions;

public class DivisionByZeroException extends CommandException {
    public DivisionByZeroException() {
        super("Division by zero");
    }
}
