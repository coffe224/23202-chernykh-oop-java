package calculator;
import calculator.commands.Command;
import calculator.exceptions.CommandFactoryException;
import calculator.exceptions.PropertiesFileException;

import calculator.exceptions.UnknownCommandClassException;
import calculator.exceptions.UnknownCommandNameException;

import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {
    private static final String PROPERTIES_FILE = "factory.properties";
    private final Properties properties;

    public CommandFactory() {
        properties = new Properties();
        InputStream inputStream = CommandFactory.class.getResourceAsStream(PROPERTIES_FILE);
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new PropertiesFileException(PROPERTIES_FILE);
        }
    }

    public Command createCommand(String commandName) throws CommandFactoryException {
        String commandClassName = properties.getProperty(commandName);
        if (commandClassName == null) {
            throw new UnknownCommandNameException(commandName);
        } else {
            try {
                Class<?> commandClass = Class.forName(commandClassName);
                Object object = commandClass.getConstructor().newInstance();
                return (Command) object;
            } catch (Exception e) {
                throw new UnknownCommandClassException(commandClassName);
            }
        }
    }
}
