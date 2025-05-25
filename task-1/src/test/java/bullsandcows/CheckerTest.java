package bullsandcows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerTest {
    @Test
    public void testRightAnswer() {
        Checker checker = new Checker();
        checker.setAnswer("1234");
        int[] answer = checker.checkGuess("1234");
        assertEquals(answer[0], 4);
        assertEquals(answer[1], 0);
    }

    @Test
    public void testWrongAnswer() {
        Checker checker = new Checker();
        checker.setAnswer("1234");
        int[] answer = checker.checkGuess("5678");
        assertEquals(answer[0], 0);
        assertEquals(answer[1], 0);
    }

    @Test
    public void testPartlyRightAnswer() {
        Checker checker = new Checker();
        checker.setAnswer("1234");
        int[] answer = checker.checkGuess("4321");
        assertEquals(answer[0], 0);
        assertEquals(answer[1], 4);
    }
}