package calculator.commands;

import calculator.ExecutionContext;

public class Print implements Command {
    public void execute(ExecutionContext executionContext, String[] args) {
        if (args.length != 0) {
            System.out.println("Invalid number of arguments");
        }

        if (executionContext.getStackSize() < 1) {
            System.out.println("Not enough values in stack");
        } else {
            double value = executionContext.peek();
            System.out.println("Value: " + value);
        }
    }
}
