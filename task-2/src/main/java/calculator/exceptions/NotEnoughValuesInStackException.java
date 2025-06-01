package calculator.exceptions;

public class NotEnoughValuesInStackException extends CommandException {
    public NotEnoughValuesInStackException(int neededValues, int stackSize) {
        super("Not enough values in calculator stack: need more than " + neededValues + ", has only " + stackSize);
    }
}
