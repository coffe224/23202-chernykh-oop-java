package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.InvalidNumberOfArgsException;
import calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    @Test
    public void popTest() {
        ExecutionContext context = new ExecutionContext();
        context.push(1);
        context.push(2);
        Pop pop = new Pop();
        try {
            pop.execute(context, new String[0]);
            assertEquals(context.peek(), 1);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void popTestBad() {
        ExecutionContext context = new ExecutionContext();
        Pop pop = new Pop();
        try {
            pop.execute(context, new String[0]);
        } catch (NotEnoughValuesInStackException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void popTestBad2() {
        ExecutionContext context = new ExecutionContext();
        Pop pop = new Pop();
        try {
            pop.execute(context, new String[]{"a"});
            fail();
        } catch (InvalidNumberOfArgsException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}