package com.company.executor;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.shared.Command;

import java.util.List;

public interface CommandExecutor {
    public void execute() throws IncompatibleCommandException, UnsupportedCommandException;
    public List<String> getSupportedCommands();
    public Command command();
}
