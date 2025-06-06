package calculator.exceptions;

public class UnknownCommandClassException extends CommandFactoryException {
    public UnknownCommandClassException(String commandName) {
        super("Unknown command class: " + commandName);
    }
}
