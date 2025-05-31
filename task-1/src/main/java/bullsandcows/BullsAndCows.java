package bullsandcows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BullsAndCows {
    private static final Logger logger = LoggerFactory.getLogger(BullsAndCows.class);
    private int bulls;
    private int cows;

    BullsAndCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public void printBullsAndCows() {
        logger.info("Bulls: {} Cows: {}", bulls, cows);
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }
}
