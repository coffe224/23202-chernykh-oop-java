package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.CommandException;
import calculator.exceptions.InvalidArgumentException;
import calculator.exceptions.InvalidNumberOfArgsException;

public class Push implements Command {
    private static final int NUM_OF_ARGS = 1;

    public void execute(ExecutionContext executionContext, String[] args) throws CommandException {
        if (args.length != NUM_OF_ARGS) {
            throw new InvalidNumberOfArgsException(this.getClass().getName(), NUM_OF_ARGS, args.length);
        }

        String arg = args[0];
        if (executionContext.contains(arg)) {
            executionContext.push(executionContext.getVariable(arg));
        } else {
            try {
                double value = Double.parseDouble(arg);
                executionContext.push(value);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException(this.getClass().getName(), arg);
            }
        }
    }
}
