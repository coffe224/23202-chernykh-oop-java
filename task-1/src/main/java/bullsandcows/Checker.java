package bullsandcows;

public class Checker {
    private String answer;

    void setAnswer(String answer_arg) {
        answer = answer_arg;
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
        return new BullsAndCows(bulls, cows);
    }
}
