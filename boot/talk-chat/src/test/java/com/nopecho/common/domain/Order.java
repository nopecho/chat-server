package com.nopecho.common.domain;

public class Order implements Aggregate {

    OrderId id;

    @Override
    public RootId getId() {
        return this.id;
    }
}
