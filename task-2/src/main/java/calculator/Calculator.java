package calculator;

import calculator.commands.Command;
import calculator.exceptions.CalculatorException;
import calculator.exceptions.PropertiesFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
    private final Parser parser;
    private final CommandFactory commandFactory;
    private final ExecutionContext executionContext;

    public Calculator() {
        this(new String[0]);
    }

    public Calculator(String[] args) {
        Scanner scanner;
        if (args.length == 0) {
            scanner = new Scanner(System.in);
        } else {
            try {
                scanner = new Scanner(new File(args[0]));
            } catch (FileNotFoundException e) {
                logger.error("File not found: {} | Scanning from console:", args[0]);
                scanner = new Scanner(System.in);
            }
        }
        this.parser = new Parser(scanner);

        try {
            this.commandFactory = new CommandFactory();
        } catch (Exception e) {
            logger.error("FATAL ERROR: {}", e.getMessage());
            throw e;
        }
        this.executionContext = new ExecutionContext();
    }

    public void start() {
        while (true) {
            ParsedCommand parsedCommand = parser.getNextCommand();
            if (parsedCommand == null) {
                break;
            }
            try {
                Command command = commandFactory.createCommand(parsedCommand.getCommandName());
                command.execute(executionContext, parsedCommand.getArguments());
            } catch (CalculatorException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
