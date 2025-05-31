package calculator;

import calculator.commands.Command;
import calculator.commands.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {
        private final Properties properties;

    CommandFactory() {
        properties = new Properties();
        InputStream inputStream = CommandFactory.class.getResourceAsStream("factory.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Can't load properties file");
        }
    }

    Command createCommand(String commandName) throws Exception {
        String commandClassName = properties.getProperty(commandName);
        if (commandClassName == null) {
            System.out.println("Unknown command: " + commandName);
            throw new Exception();
        } else {
            try {
                Class<?> commandClass = Class.forName(commandClassName);
                Object object = commandClass.getConstructor().newInstance();
                return (Command) object;
            } catch (Exception e) {
                System.out.println("Unknown class: " + commandClassName);
                throw new Exception();
            }
        }
    }
}
