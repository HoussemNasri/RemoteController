package com.company.executor;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.shared.Command;

import java.util.List;

public class CmdCommandExecutor implements CommandExecutor {
    private Command command;

    public CmdCommandExecutor(Command command) {
        this.command = command;
    }

    @Override
    public void execute() throws IncompatibleCommandException, UnsupportedCommandException {

    }

    @Override
    public List<String> getSupportedCommands() {
        return null;
    }
}
