package bullsandcows;

import java.util.Scanner;
import exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputScanner {
    private static final Logger logger = LoggerFactory.getLogger(InputScanner.class);

    public String scanNumber(int length) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter a number:");
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
