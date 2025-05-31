package calculator.commands;

import calculator.ExecutionContext;

public class Push implements Command {
    public void execute(ExecutionContext executionContext, String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
        }

        String arg = args[0];
        if (executionContext.contains(arg)) {
            executionContext.push(executionContext.getVariable(arg));
        } else {
            try {
                double value = Double.parseDouble(arg);
                executionContext.push(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument");
            }
        }
    }
}
