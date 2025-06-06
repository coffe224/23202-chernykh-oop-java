package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private final Map<String, Double> variables;
    private final Stack<Double> calculatorStack;

    public ExecutionContext() {
        this.variables = new HashMap<>();
        this.calculatorStack = new Stack<>();
    }

    public boolean contains(String variableName) {
        return variables.containsKey(variableName);
    }

    public double getVariable(String variableName) {
        return this.variables.get(variableName);
    }

    public void setVariable(String variableName, double value) {
        this.variables.put(variableName, value);
    }

    public double peek() {
        return this.calculatorStack.peek();
    }

    public void pop() {
        this.calculatorStack.pop();
    }

    public void push(double value) {
        this.calculatorStack.push(value);
    }

    public int getStackSize() {
        return this.calculatorStack.size();
    }
}
