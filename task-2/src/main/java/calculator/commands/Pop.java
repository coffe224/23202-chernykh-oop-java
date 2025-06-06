package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.CommandException;
import calculator.exceptions.InvalidNumberOfArgsException;
import calculator.exceptions.NotEnoughValuesInStackException;

public class Pop implements Command {
    private static final int MIN_STACK_SIZE = 1;
    private static final int NUM_OF_ARGS = 0;

    public void execute(ExecutionContext executionContext, String[] args) throws CommandException {
        if (args.length != NUM_OF_ARGS) {
            throw new InvalidNumberOfArgsException(this.getClass().getName(), NUM_OF_ARGS, args.length);
        }

        if (executionContext.getStackSize() < MIN_STACK_SIZE) {
            throw new NotEnoughValuesInStackException(MIN_STACK_SIZE, executionContext.getStackSize());
        } else {
            executionContext.pop();
        }
    }
}
