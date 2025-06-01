package calculator.exceptions;

public class InvalidNumberOfArgsException extends CommandException {
    public InvalidNumberOfArgsException(String commandName, int defaultNumOfArgs, int wrongNumOfArgs) {
        super("Invalid number of arguments in " + commandName + ": expected " + defaultNumOfArgs + ", got " + wrongNumOfArgs);
    }
}
