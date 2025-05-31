package calculator;

import java.util.Scanner;

public class Parser {
    private final Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    public ParsedInputString getNextString() {
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.charAt(0) != '#') {
                return createParsedInputString(input);
            }
        }
        return null;
    }

    private ParsedInputString createParsedInputString(String inputString) {
        String[] tokens = inputString.split(" ", 2);

        ParsedInputString parsedInput = new ParsedInputString();
        if (tokens.length > 0) {
            parsedInput.setCommandName(tokens[0]);
        }
        if (tokens.length > 1) {
            parsedInput.setArguments(tokens[1].split(" "));
        }
        return parsedInput;
    }
}
