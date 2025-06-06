package calculator;

import java.util.Scanner;

public class Parser {
    private final Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    public ParsedCommand getNextCommand() {
        while (scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            String[] tokens = inputString.trim().split("\\s+", 2);
            if (tokens.length == 0) {
                continue;
            }
            if (tokens.length == 1 && tokens[0].isEmpty()) {
                continue;
            }
            if (tokens[0].charAt(0) == '#') {
                continue;
            }
            return createParsedInputString(tokens);
        }
        return null;
    }

    private ParsedCommand createParsedInputString(String[] inputTokens) {
        ParsedCommand parsedCommand = new ParsedCommand();
        parsedCommand.setCommandName(inputTokens[0]);

        if (inputTokens.length > 1) {
            parsedCommand.setArguments(inputTokens[1].split("\\s+"));
        }
        return parsedCommand;
    }
}
