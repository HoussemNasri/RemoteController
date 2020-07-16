package com.company.exception;

public class IncompatibleCommandException extends Exception{
    public IncompatibleCommandException(String whatWasProvided, String whatShouldHaveBeen){
        super("You have provided a command of type "
                + whatWasProvided + " But What you should have provided is a "
                + whatShouldHaveBeen + " Command Type");
    }
}
