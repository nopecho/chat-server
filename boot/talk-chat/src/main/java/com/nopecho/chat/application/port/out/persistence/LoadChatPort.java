package com.nopecho.chat.application.port.out.persistence;

import com.nopecho.chat.domain.Chat;

import java.util.List;

public interface LoadChatPort {

    Chat loadById(Long chatId);
    List<Chat> loadAllByUserId(Long userId);
}
