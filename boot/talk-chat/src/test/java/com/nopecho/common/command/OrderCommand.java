package com.nopecho.common.command;

import lombok.Value;

@Value(staticConstructor = "of")
public class OrderCommand implements Command {

    Long userId;
    Long productId;

    @Override
    public Type getType() {
        return Type.ORDER;
    }
}
