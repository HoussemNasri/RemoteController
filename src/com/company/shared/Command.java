package com.company.shared;

public class Command {
    private CommandType commandType;
    private CommandContent commandContent;

    public Command(CommandType commandType, CommandContent commandContent) {
        this.commandType = commandType;
        this.commandContent = commandContent;
    }

    public CommandType getType() {
        return commandType;
    }

    public CommandContent getContent() {
        return commandContent;
    }
}
