package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.InvalidArgumentException;
import calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {
    @Test
    public void pushTest() {
        ExecutionContext context = new ExecutionContext();
        Push push = new Push();
        try {
            push.execute(context, new String[]{"1"});
            assertEquals(context.peek(), 1);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void pushTestBad() {
        ExecutionContext context = new ExecutionContext();
        Push push = new Push();
        try {
            push.execute(context, new String[]{"a"});
        } catch (InvalidArgumentException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void pushTest2() {
        ExecutionContext context = new ExecutionContext();
        context.setVariable("a", 1);
        Push push = new Push();
        try {
            push.execute(context, new String[]{"a"});
            assertEquals(context.peek(), 1);
        } catch (Exception e) {
            fail();
        }
    }
}