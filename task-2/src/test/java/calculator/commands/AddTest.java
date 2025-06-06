package calculator.commands;

import calculator.ExecutionContext;
import calculator.exceptions.InvalidNumberOfArgsException;
import calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    @Test
    public void addTest() {
        ExecutionContext context = new ExecutionContext();
        context.push(1);
        context.push(2);
        Add add = new Add();
        try {
            add.execute(context, new String[0]);
            assertEquals(context.peek(), 3);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void addTestBad() {
        ExecutionContext context = new ExecutionContext();
        context.push(1);
        Add add = new Add();
        try {
            add.execute(context, new String[0]);
        } catch (NotEnoughValuesInStackException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void addTestBad2() {
        ExecutionContext context = new ExecutionContext();
        context.push(1);
        context.push(2);
        Add add = new Add();
        try {
            add.execute(context, new String[]{"a"});
            fail();
        } catch (InvalidNumberOfArgsException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}