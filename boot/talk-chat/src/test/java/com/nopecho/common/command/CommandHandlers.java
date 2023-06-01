package com.nopecho.common.command;

import java.util.ArrayList;
import java.util.List;

public class CommandHandlers {

    private final List<CommandHandler> handlers = new ArrayList<>();

    public void add(CommandHandler handler) {
        handlers.add(handler);
    }

    public void handle(Command command) {
        CommandHandler handler = handlers.stream()
                .filter(h -> h.isSupported(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found handler that support command"));

        handler.handle(command);
    }
}
