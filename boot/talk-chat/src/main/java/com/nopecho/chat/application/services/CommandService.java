package com.nopecho.chat.application.services;

import com.nopecho.chat.application.port.out.cache.ChannelCachePort;
import com.nopecho.chat.application.port.out.persistence.CreateChatPort;
import com.nopecho.chat.application.usecase.CreateChatUseCase;
import com.nopecho.chat.application.usecase.DeleteChatUseCase;
import com.nopecho.chat.application.usecase.dto.Request;
import com.nopecho.chat.application.usecase.dto.Response;
import com.nopecho.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CommandService implements CreateChatUseCase, DeleteChatUseCase {

    private final CreateChatPort createPort;
    private final ChannelCachePort channelCachePort;

    @Override
    public Response.Create create(Request.Create request) {
        Chat saved = createPort.create(ChatFactory.create(request));

        Long channelId = saved.getChannel().getId();
        channelCachePort.setChannel(channelId);
        return new Response.Create(saved.getId(), channelId);
    }

    @Override
    public void delete(Long chatId) {
    }
}