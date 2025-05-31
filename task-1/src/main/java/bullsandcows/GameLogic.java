package bullsandcows;

import exceptions.BadLengthException;
import exceptions.DuplicateDigitException;
import exceptions.NotANumberException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameLogic {
    private static final int LENGTH_OF_NUMBER = 4;
    private static final Logger logger = LoggerFactory.getLogger(GameLogic.class);

    private final Checker checker;
    private final NumberGenerator numberGenerator;
    private final InputScanner inputScanner;

    GameLogic() {
        checker = new Checker();
        numberGenerator = new NumberGenerator();
        inputScanner = new InputScanner();
    }

    public void start() {
        String answer = numberGenerator.generate(LENGTH_OF_NUMBER);
        checker.setAnswer(answer);

        logger.info("Start GAME!");
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            String guess;
            try {
                guess = inputScanner.scanNumber(LENGTH_OF_NUMBER);
            } catch (BadLengthException e) {
                logger.error("Bad length");
                continue;
            } catch (NotANumberException e) {
                logger.error("Not a number");
                continue;
            } catch (DuplicateDigitException e) {
                logger.error("Duplicate digit");
                continue;
            }

            BullsAndCows result = checker.checkGuess(guess);
            result.printBullsAndCows();

            if (result.getBulls() == LENGTH_OF_NUMBER) {
                logger.info("You win!");
                break;
            }
        }
    }
}
