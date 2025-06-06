package calculator;

import calculator.commands.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {
    @Test
    public void test1() {
        CommandFactory commandFactory = new CommandFactory();
        ExecutionContext executionContext = new ExecutionContext();
        try {
            Command command = commandFactory.createCommand("PUSH");
            command.execute(executionContext, new String[]{"2"});
            assertEquals(executionContext.peek(), 2);
        } catch (Exception e) {
            fail();
        }
    }
}