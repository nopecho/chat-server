package com.nopecho.message.adapters.in;

import com.nopecho.message.application.usecase.PublishMessageUseCase;
import com.nopecho.message.application.usecase.dto.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MessageHandler {

    private final PublishMessageUseCase publishMessageUseCase;

    @MessageMapping("/channel/{channelId}")
    public void onMessage(@Payload Request.Message message,
                          @DestinationVariable long channelId) {
        publishMessageUseCase.publish(message, channelId);
    }
}