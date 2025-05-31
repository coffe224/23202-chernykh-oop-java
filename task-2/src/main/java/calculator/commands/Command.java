package calculator.commands;

import calculator.ExecutionContext;

public interface Command {
    void execute(ExecutionContext executionContext, String[] args);
}
