package calculator.exceptions;

public class PropertiesFileException extends RuntimeException {
    public PropertiesFileException(String propertiesFileName) {
        super("Can't open properties file: " + propertiesFileName);
    }
}
