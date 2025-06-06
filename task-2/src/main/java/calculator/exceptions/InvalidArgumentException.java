package calculator.exceptions;

public class InvalidArgumentException extends CommandException {
    public InvalidArgumentException(String commandName, String argument) {
        super("Invalid argument in " + commandName + ": " + argument);
    }
}
