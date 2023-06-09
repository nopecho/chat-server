package com.nopecho.chat.adapters.out.persistence;

import com.nopecho.chat.domain.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends MongoRepository<Chat, Long> {

    Optional<Chat> findChatByChannel_Id(Long channelId);
    List<Chat> findAllByUserId(Long userId);
}
