package com.company.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandContent {
    private String commandName;
    private List<String> params = new ArrayList<>();

    public CommandContent(String commandName, String ... params){
        this.commandName = commandName;
        this.params.addAll(Arrays.asList(params));
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
