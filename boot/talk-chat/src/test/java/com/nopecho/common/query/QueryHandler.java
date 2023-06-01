package com.nopecho.common.query;

import com.nopecho.common.domain.Aggregate;

public interface QueryHandler<DOMAIN extends Aggregate> {

    DOMAIN findById(Long id);
}
