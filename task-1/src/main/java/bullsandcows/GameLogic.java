package src.main.java.bullsandcows;

import java.util.InputMismatchException;
import java.util.Objects;

public class GameLogic {
    private static final int LENGTH_OF_NUMBER = 4;
    private Checker checker;
    private OutputHandler outputHandler;


    public void start() {
        NumberGenerator generator = new NumberGenerator();
        String answer = generator.generate(LENGTH_OF_NUMBER);

        checker = new Checker();
        checker.setAnswer(answer);

        outputHandler = new OutputHandler();
        outputHandler.printGameStart();

        gameLoop();
    }

    private void gameLoop() {

        InputScanner scanner = new InputScanner();

        while (true) {
            String guess;
            try {
                guess = scanner.scanNumber(LENGTH_OF_NUMBER);
            } catch (InputMismatchException e) {
                String message = e.getMessage();
                if (Objects.equals(message, "bad length")) {
                    outputHandler.printBadLengthError();
                } else if (Objects.equals(message, "not a number character")) {
                    outputHandler.printNotANumberError();
                } else if (Objects.equals(message, "duplicate digit")) {
                    outputHandler.printDuplicateDigitsError();
                }
                continue;
            }

            int[] result = checker.checkGuess(guess);

            outputHandler.printBullsAndCows(result[0], result[1]);

            if (result[0] == LENGTH_OF_NUMBER) {
                outputHandler.printWin();
                break;
            }
        }
    }
}
