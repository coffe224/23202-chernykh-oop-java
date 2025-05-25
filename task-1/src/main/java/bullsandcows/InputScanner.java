package bullsandcows;

import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.*;

public class InputScanner {
    public String scanNumber(int length) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String string = scanner.nextLine();

        if (string.length() != length) {
            throw new BadLengthException();
        }

        int[] duplicateArray = new int[10];
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                throw new NotANumberException();
            }

            int number = string.charAt(i) - '0';
            if (duplicateArray[number] == 1) {
                throw new DuplicateDigitException();
            }
            duplicateArray[number]++;
        }

        return string;
    }
}
