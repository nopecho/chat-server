package com.nopecho.chat.adapters.in;

import com.nopecho.chat.application.usecase.CreateChatUseCase;
import com.nopecho.chat.application.usecase.DeleteChatUseCase;
import com.nopecho.chat.application.usecase.dto.Request;
import com.nopecho.chat.application.usecase.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class CommandChatController {

    private final CreateChatUseCase createUseCase;
    private final DeleteChatUseCase deleteUseCase;

    @PutMapping("/chats")
    public ResponseEntity<Response.Create> create(@RequestBody Request.Create request) {
        Response.Create created = createUseCase.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/chats/{chatId}")
    public void delete(@PathVariable Long chatId) {
        deleteUseCase.delete(chatId);
    }
}