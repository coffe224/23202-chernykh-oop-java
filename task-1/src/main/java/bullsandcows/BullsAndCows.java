package bullsandcows;

public class BullsAndCows {
    private int bulls;
    private int cows;

    BullsAndCows() {
        this.bulls = 0;
        this.cows = 0;
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
