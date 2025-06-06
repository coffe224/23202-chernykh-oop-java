package calculator.exceptions;

public class UnknownCommandNameException extends CommandFactoryException {
    public UnknownCommandNameException(String commandName) {
        super("Unknown command: " + commandName);
    }
}
