package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.CommandException;

public interface Command {
    void execute(ExecutionContext executionContext, String[] args) throws CommandException;
}
