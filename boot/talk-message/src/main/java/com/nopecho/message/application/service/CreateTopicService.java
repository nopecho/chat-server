package com.nopecho.message.application.service;

import com.nopecho.message.application.usecase.CreateTopicUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import static com.sib.utils.generator.RedisConst.PREFIX_CHANNEL;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateTopicService implements CreateTopicUseCase {

    private final RedisMessageListenerContainer listenerContainer;
    private final MessageListenerAdapter listenerAdapter;

    @Override
    public void createTopic(long channelId) {
        listenerContainer.addMessageListener(listenerAdapter, getChannelTopic(channelId));
    }

    private ChannelTopic getChannelTopic(long channelId) {
        return ChannelTopic.of(PREFIX_CHANNEL+ channelId);
    }
}
