package com.nopecho.chat.application.usecase.dto;

import com.nopecho.chat.domain.Channel;
import com.sib.vo.ChatMessage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public interface Response {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Create {
        @NotNull
        private Long chatId;
        @NotNull
        private Long channelId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Connect {
        @NotNull
        private Long userId;
        @NotNull
        private Long channelId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Chat {
        private Long chatId;
        private Long channelId;
        private String title;
        private ChatMessage lastChatMessage;
        private LocalDateTime createdAt;

        public static Response.Chat convert(com.nopecho.chat.domain.Chat chat) {
            Channel channel = chat.getChannel();
            List<ChatMessage> chatMessages = channel.getChatMessages();
            if(chatMessages.isEmpty()) {
                return new Response.Chat(
                        chat.getId(),
                        channel.getId(),
                        channel.getTitle(),
                        null,
                        chat.getCreatedAt()
                );
            }
            int lastIndex = chatMessages.size() - 1;
            return new Response.Chat(
                    chat.getId(),
                    channel.getId(),
                    channel.getTitle(),
                    chatMessages.get(lastIndex),
                    chat.getCreatedAt()
            );
        }
    }
}