package com.company.exception;

import java.util.List;

public class UnsupportedCommandException extends Exception{
    public UnsupportedCommandException(String command, List<String> supportedCommands){
        super(command + " is not supported\n" + formattedList(supportedCommands));
    }

    public static String formattedList(List<String> strings){
        StringBuilder formatted = new StringBuilder();
        int i = 1;
        for (String s : strings)
            formatted.append(String.format("%d-%s\n", i++, s));
        return formatted.toString();
    }
}
