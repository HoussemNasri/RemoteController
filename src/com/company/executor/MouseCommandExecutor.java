package com.company.executor;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.shared.Command;
import com.company.shared.CommandConstants;
import com.company.shared.CommandContent;
import com.company.shared.CommandType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MouseCommandExecutor implements CommandExecutor {
    private final Command command;
    private Robot robot;

    public MouseCommandExecutor(Command command) {
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

        if (commandType != CommandType.MOUSE)
            throw new IncompatibleCommandException(commandType.name(), CommandType.MOUSE.name());

        if (!getSupportedCommands().contains(commandName))
            throw new UnsupportedCommandException(commandName, getSupportedCommands());

        List<Object> params = content.getParams();
        int paramsSize = params.size();
        System.out.println(paramsSize);

        int mouseButton = paramsSize > 0 ? (int) content.getParams().get(0) : -1;
        int numberOfClicks = paramsSize > 1 ? (int) content.getParams().get(1) : 1;
        int delayBetweenClicks = paramsSize > 2 ? (int) content.getParams().get(2) : 200;

        if (commandName.equals(CommandConstants.PRESS_MOUSE)) {
            /*Left Button*/
            if (mouseButton == 1) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            }
            /*Middle Button*/
            else if (mouseButton == 2) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mousePress(KeyEvent.BUTTON2_DOWN_MASK);

            }
            /*Right Button*/
            else if (mouseButton == 3) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
            }
        } else if (commandName.equals(CommandConstants.RELEASE_MOUSE)) {
            /*Left Button*/
            if (mouseButton == 1) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
            /*Middle Button*/
            else if (mouseButton == 2) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mouseRelease(KeyEvent.BUTTON2_DOWN_MASK);
            }
            /*Right Button*/
            else if (mouseButton == 3) {
                for (int i = 0; i < numberOfClicks; i++)
                    this.robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
            }
        }

        else if (commandName.equals(CommandConstants.CLICK_MOUSE)) {
            /*Left Button*/
            if (mouseButton == 1) {
                for (int i = 0; i < numberOfClicks; i++){
                    this.robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    this.robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                }
            }
            /*Middle Button*/
            else if (mouseButton == 2) {
                for (int i = 0; i < numberOfClicks; i++){
                    this.robot.mousePress(KeyEvent.BUTTON2_DOWN_MASK);
                    this.robot.mouseRelease(KeyEvent.BUTTON2_DOWN_MASK);
                }
            }
            /*Right Button*/
            else if (mouseButton == 3) {
                for (int i = 0; i < numberOfClicks; i++){
                    this.robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
                    this.robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
                }
            }
        }
    }

    @Override
    public List<String> getSupportedCommands() {
        return List.of(CommandConstants.PRESS_MOUSE, CommandConstants.RELEASE_MOUSE, CommandConstants.CLICK_MOUSE);
    }

    @Override
    public Command command() {
        return this.command;
    }
}
