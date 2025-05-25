package src.main.java.bullsandcows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    public String scanNumber(int length) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String string = scanner.nextLine();

        if (string.length() != length) {
            throw new InputMismatchException("bad length");
        }

        int[] duplicateArray = new int[10];
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                throw new InputMismatchException("not a number character");
            }

            int number = string.charAt(i) - '0';
            if (duplicateArray[number] == 1) {
                throw new InputMismatchException("duplicate digit");
            }
            duplicateArray[number]++;
        }

        return string;
    }
}
