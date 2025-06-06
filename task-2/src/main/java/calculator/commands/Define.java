package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.CommandException;
import calculator.exceptions.InvalidArgumentException;
import calculator.exceptions.InvalidNumberOfArgsException;
import calculator.exceptions.NotAllowedVariableNameException;

public class Define implements Command {
    private static final int NUM_OF_ARGS = 2;

    public void execute(ExecutionContext executionContext, String[] args) throws CommandException {
        if (args.length != NUM_OF_ARGS) {
            throw new InvalidNumberOfArgsException(this.getClass().getName(), NUM_OF_ARGS, args.length);
        }

        String variableName = args[0];

        if (!isAllowedName((variableName))) {
            throw new NotAllowedVariableNameException(variableName);
        }

        double value;
        String valueArg = args[1];
        try {
            value = Double.parseDouble(valueArg);
            executionContext.push(value);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(this.getClass().getName(), valueArg);
        }
        executionContext.setVariable(variableName, value);
    }

    private boolean isAllowedName(String name) {
        if (name.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(name);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}