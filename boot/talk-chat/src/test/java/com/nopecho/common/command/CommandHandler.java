package com.nopecho.common.command;

public interface CommandHandler {

    void handle(Command command);

    boolean isSupported(Command command);
}
