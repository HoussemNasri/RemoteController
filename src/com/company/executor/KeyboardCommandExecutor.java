package com.company.executor;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.shared.Command;
import com.company.shared.CommandConstants;
import com.company.shared.CommandContent;
import com.company.shared.CommandType;

import java.awt.*;
import java.util.List;

public class KeyboardCommandExecutor implements CommandExecutor {
    private Command command;
    private Robot robot;

    public KeyboardCommandExecutor(Command command) {
        this.command = command;
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() throws IncompatibleCommandException, UnsupportedCommandException {
        CommandContent content = command().getContent();
        String commandName = content.getCommandName();
        CommandType commandType = command().getType();

        if (commandType != CommandType.KEYBOARD)
            throw new IncompatibleCommandException(commandType.name(), CommandType.KEYBOARD.name());

        if (!getSupportedCommands().contains(commandName))
            throw new UnsupportedCommandException(commandName, getSupportedCommands());

        int keyCode = (int) content.getParams().get(0);

        if (commandName.equals(CommandConstants.PRESS_KEY)) {
            robot.keyPress(keyCode);
        } else if (commandName.equals(CommandConstants.RELEASE_KEY)) {
            robot.keyRelease(keyCode);
        }

        System.out.println("Command Name : " + content.getCommandName());
        System.out.println("Params : " + content.getParams());

    }

    @Override
    public List<String> getSupportedCommands() {
        return List.of(CommandConstants.PRESS_KEY, CommandConstants.RELEASE_KEY);
    }

    @Override
    public Command command() {
        return this.command;
    }
}
