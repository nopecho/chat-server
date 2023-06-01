package com.nopecho.message.application.usecase;

import com.nopecho.message.application.usecase.dto.Response;

import java.util.List;

public interface QueryMessageUseCase {

    List<Response.Message> queryAllByChannelId(Long channelId);
}
