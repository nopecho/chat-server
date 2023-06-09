package com.nopecho.chat.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Document(collection = "chat")
public class Chat {

    @Id
    private Long id;
    private Long userId;
    private Channel channel;
    private Method method;
    private Status status;
    private LocalDateTime createdAt;
}
