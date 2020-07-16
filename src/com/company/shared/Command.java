package com.company.shared;

import java.io.Serializable;

public class Command implements Serializable {
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
