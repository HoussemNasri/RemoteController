package com.company;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.shared.Command;
import com.company.shared.CommandConstants;
import com.company.shared.CommandContent;
import com.company.shared.CommandType;

import java.util.List;

public class KeyboardCommandExecutor implements CommandExecutor{

    @Override
    public void execute(Command command) throws IncompatibleCommandException, UnsupportedCommandException {
        if (command.getType() != CommandType.KEYBOARD)
            throw new IncompatibleCommandException(command.getType().name(), CommandType.KEYBOARD.name());

        CommandContent content = command.getContent();
        String commandName = content.getCommandName();

        if (!getSupportedCommands().contains(commandName))
            throw new UnsupportedCommandException(commandName, getSupportedCommands());

    }

    @Override
    public List<String> getSupportedCommands() {
        return List.of(CommandConstants.PRESS_KEY, CommandConstants.RELEASE_KEY);
    }
}
