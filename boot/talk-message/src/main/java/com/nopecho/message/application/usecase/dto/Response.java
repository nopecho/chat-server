package com.nopecho.message.application.usecase.dto;

import com.sib.vo.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface Response {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Message {
        private Long id;
        private String type;
        private Long senderId;
        private String sendAt;
        private String content;

        public static Response.Message convert(ChatMessage message) {
            return new Response.Message(
                    message.getId(),
                    message.getType().toString(),
                    message.getSenderId(),
                    message.getSendAt(),
                    message.getContent()
            );
        }
    }
}
