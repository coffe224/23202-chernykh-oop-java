package src.main.java.bullsandcows;

public class OutputHandler {
    public void print(int bulls, int cows) {
        System.out.println("Bulls: " + bulls + "; Cows: " + cows);
    }

    public void printAttempts(int attempts, int current_attempt) {
        System.out.println("You have " + (attempts - current_attempt) + " left.");
    }

    public void printWin() {
        System.out.println("You win!");
    }
    public void printLose() {
        System.out.println("You lose :(");
    }

    public void printWelcome() {};
    public void printTryAgainInput() {};

    public void printSeeYouNextTime() {};
}
