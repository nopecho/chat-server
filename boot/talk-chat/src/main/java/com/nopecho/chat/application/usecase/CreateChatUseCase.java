package com.nopecho.chat.application.usecase;

import com.nopecho.chat.application.usecase.dto.Request;
import com.nopecho.chat.application.usecase.dto.Response;

public interface CreateChatUseCase {

    Response.Create create(Request.Create req);
}