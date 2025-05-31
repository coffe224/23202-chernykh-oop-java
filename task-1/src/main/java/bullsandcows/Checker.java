package bullsandcows;

public class Checker {
    private String answer;

    void setAnswer(String answerArg) {
        answer = answerArg;
    }

    public BullsAndCows checkGuess(String guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < answer.length(); i++) {
            char c = guess.charAt(i);
            if (c == answer.charAt(i)) {
                bulls++;
            } else if (answer.contains(String.valueOf(c))) {
                cows++;
            }
        }

        BullsAndCows bc = new BullsAndCows();
        bc.setBulls(bulls);
        bc.setCows(cows);

        return bc;
    }
}
