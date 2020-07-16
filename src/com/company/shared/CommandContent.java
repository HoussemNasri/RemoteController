package com.company.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandContent implements Serializable {
    private String commandName;
    private List<Object> params = new ArrayList<>();

    public CommandContent(String commandName, Object ... params){
        this.commandName = commandName;
        this.params.addAll(Arrays.asList(params));
    }

    public String getCommandName() {
        return commandName;
    }

    public List<Object> getParams() {
        return params;
    }
}
