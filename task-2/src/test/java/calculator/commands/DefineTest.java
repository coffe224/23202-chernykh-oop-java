package calculator.commands;

import calculator.ExecutionContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {
    @Test
    public void pushTest() {
        ExecutionContext context = new ExecutionContext();
        Define define = new Define();
        try {
            define.execute(context, new String[]{"a", "1"});
            assertEquals(context.getVariable("a"), 1);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void pushTestBad() {
        ExecutionContext context = new ExecutionContext();
        Define define = new Define();
        try {
            define.execute(context, new String[]{"a", "1"});
            assertFalse(context.contains("b"));
        } catch (Exception e) {
            fail();
        }
    }
}