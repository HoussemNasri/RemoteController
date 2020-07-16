package com.company.executor;

import com.company.shared.Command;
import com.company.shared.CommandType;

public class CommandExecutorFactory {
    public static CommandExecutor create(Command command) {
        if (command.getType() == CommandType.KEYBOARD)
            return new KeyboardCommandExecutor(command);
        if (command.getType() == CommandType.CMD)
            return new CmdCommandExecutor(command);
        return null;
    }
}
