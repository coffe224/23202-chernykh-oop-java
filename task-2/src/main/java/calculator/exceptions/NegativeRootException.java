package calculator.exceptions;

public class NegativeRootException extends CommandException {
    public NegativeRootException(double number) {
        super("Can't take square root of " + number);
    }
}
