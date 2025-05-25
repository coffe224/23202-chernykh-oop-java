package src.main.java.bullsandcows;

import java.util.InputMismatchException;
import java.util.Objects;

public class GameLogic {
    private Checker checker;
    private static final int LENGTH_OF_NUMBER = 4;

    public void start() {
        NumberGenerator generator = new NumberGenerator();
        String answer = generator.generate(LENGTH_OF_NUMBER);

        checker = new Checker();
        checker.setAnswer(answer);

        gameLoop();
    }

    private void gameLoop() {
        InputScanner scanner = new InputScanner();
        OutputHandler outputHandler = new OutputHandler();
        while (true) {
            String guess;
            try {
                guess = scanner.scanNumber(LENGTH_OF_NUMBER);
            } catch (InputMismatchException e) {
                String message = e.getMessage();
                if (Objects.equals(message, "bad length")) {

                } else if (Objects.equals(message, "not a number character")) {

                } else if (Objects.equals(message, "duplicate number")) {

                }
                // print "try again"
                continue;
            }

            int[] result = checker.checkGuess(guess);

            outputHandler.print(result[0], result[1]);

            if (result[0] == LENGTH_OF_NUMBER) {
                outputHandler.printWin();
                break;
            }

            current_attempt++;

            if (current_attempt == LENGTH_OF_NUMBER) {
                outputHandler.printLose();
                break;
            }
        }
    }
}
