package com.nopecho.common.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class OrderId implements RootId{

    Long id;

    @Override
    public Long get() {
        return this.id;
    }
}
