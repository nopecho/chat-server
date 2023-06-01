package com.nopecho.common.command;

public class OrderCommandHandler implements CommandHandler {

    @Override
    public boolean isSupported(Command command) {
        return command.getType().equals(Type.ORDER)
                && command.getClass().equals(OrderCommand.class);
    }

    @Override
    public void handle(Command command) {
        OrderCommand orderCommand = convert(command);
        //do anything
    }

    private OrderCommand convert(Command command) {
        return (OrderCommand) command;
    }
}
