package calculator;

public class ParsedCommand {
    private String commandName;
    private String[] arguments;

    public ParsedCommand() {
        this.commandName = "";
        this.arguments = new String[0];
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
}
