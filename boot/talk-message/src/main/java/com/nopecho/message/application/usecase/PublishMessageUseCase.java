package com.nopecho.message.application.usecase;

import com.nopecho.message.application.usecase.dto.Request;

public interface PublishMessageUseCase {
    void publish(Request.Message message, long channelId);
}
