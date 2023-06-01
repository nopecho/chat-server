package com.nopecho.chat.application.port.out.persistence;

import com.nopecho.chat.domain.Chat;

public interface CreateChatPort {

    Chat create(Chat chat);
}
