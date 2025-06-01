package calculator.exceptions;

public class NotAllowedVariableNameException extends CommandException {
    public NotAllowedVariableNameException(String variableName) {
        super("Variable name " + variableName + " is not allowed");
    }
}
