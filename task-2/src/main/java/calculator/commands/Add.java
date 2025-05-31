package calculator.commands;

import calculator.ExecutionContext;

public class Add implements Command {
    public void execute(ExecutionContext executionContext, String[] args) {
        if (args.length != 0) {
            System.out.println("Invalid number of arguments");
        }

        if (executionContext.getStackSize() < 2) {
            System.out.println("Not enough values in stack");
        } else {
            double value1 = executionContext.peek();
            executionContext.pop();

            double value2 = executionContext.peek();
            executionContext.pop();

            executionContext.push(value1 + value2);
        }
    }
}
