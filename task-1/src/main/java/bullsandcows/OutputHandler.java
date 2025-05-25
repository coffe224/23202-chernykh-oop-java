package bullsandcows;

public class OutputHandler {
    public void printBullsAndCows(int bulls, int cows) {
        System.out.println("Bulls: " + bulls + "; Cows: " + cows);
    }

    public void printWin() {
        System.out.println("You win!");
    }

    public void printGameStart() { System.out.println("BULLS AND COWS!!! Guess the number!"); }

    public void printBadLengthError() { System.out.println("Bad length!"); }

    public void printNotANumberError() { System.out.println("This is not a number!"); }

    public void printDuplicateDigitsError() { System.out.println("Digits should be unique!"); }
}
