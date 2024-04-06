package org.example.chattest.chatMessage.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@RequiredArgsConstructor
@Component
@Slf4j
public class StompHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        //todo
        // 1. 인증인가 작업
        Message<?> message1 = ChannelInterceptor.super.preSend(message, channel);
        return ChannelInterceptor.super.preSend(message, channel);
    }

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent event){
        //todo 세션 추가(redis)
        log.info("사용자 입장");
    }
    @EventListener
    public void handleWebSocketDisconnectionListener(SessionDisconnectEvent event){
        //todo 세션 삭제(redis)
        log.info("사용자 퇴장");
    }
}
