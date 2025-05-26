package bullsandcows;

import exceptions.*;

public class GameLogic {
    private static final int LENGTH_OF_NUMBER = 4;

    private final Checker checker;
    private final OutputHandler outputHandler;
    private final NumberGenerator numberGenerator;
    private final InputScanner inputScanner;

    GameLogic() {
        checker = new Checker();
        numberGenerator = new NumberGenerator();
        outputHandler = new OutputHandler();
        inputScanner = new InputScanner();
    }


    public void start() {
        String answer = numberGenerator.generate(LENGTH_OF_NUMBER);
        checker.setAnswer(answer);

        outputHandler.printGameStart();
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            String guess;
            try {
                guess = inputScanner.scanNumber(LENGTH_OF_NUMBER);
            } catch (BadLengthException e) {
                outputHandler.printBadLengthError();
                continue;
            } catch (NotANumberException e) {
                outputHandler.printNotANumberError();
                continue;
            } catch (DuplicateDigitException e) {
                outputHandler.printDuplicateDigitsError();
                continue;
            }

            BullsAndCows result = checker.checkGuess(guess);

            outputHandler.printBullsAndCows(result.getBulls(), result.getCows());

            if (result.getBulls() == LENGTH_OF_NUMBER) {
                outputHandler.printWin();
                break;
            }
        }
    }
}
