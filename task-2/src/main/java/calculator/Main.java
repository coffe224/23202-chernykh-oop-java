package calculator;

import calculator.commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        if (args.length == 1) {
            try {
                scanner = new Scanner(new File(args[0]));
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + args[0] + " | Scanning from console:");
                scanner = new Scanner(System.in);
            }
        } else {
            scanner = new Scanner(System.in);
        }

        Parser parser = new Parser(scanner);
        CommandFactory commandFactory = new CommandFactory();
        ExecutionContext executionContext = new ExecutionContext();

        while (true) {
            ParsedInputString parsedInputString = parser.getNextString();
            if (parsedInputString == null) {
                break;
            }
            try {
                Command command = commandFactory.createCommand(parsedInputString.getCommandName());
                command.execute(executionContext, parsedInputString.getArguments());
            } catch (Exception e) {
                System.out.println("Something wrong I can feel it");
            }
        }

    }
}