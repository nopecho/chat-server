package com.nopecho.chat.application.services;

import com.nopecho.chat.domain.Channel;
import com.nopecho.chat.application.usecase.dto.Request;
import com.nopecho.chat.domain.Chat;
import com.nopecho.chat.domain.Status;
import com.sib.utils.generator.IdGenerator;

import java.time.LocalDateTime;

public class ChatFactory {

    public static Chat create(Request.Create request) {
        Channel channel = ChannelFactory.create(request.getReceiverIds());

        return Chat.builder()
                .id(IdGenerator.nextId())
                .userId(request.getUserId())
                .channel(channel)
                .method(request.getMethod())
                .status(Status.ACTIVATED)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
