package org.example.chattest.chatMessage.config;


import lombok.RequiredArgsConstructor;
import org.example.chattest.chatMessage.util.StompHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker // WebSocket을 활성화 하고 메시지 브로커 사용 가능
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final StompHandler stompHandler;

    // STOMP 엔드포인트를 등록하는 메서드
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // STOMP 엔드포인트
                .setAllowedOriginPatterns("*"); // 모든 Origin 허용 -> 배포시에는 보안을 위해 Origin을 정확히 지정
//                .withSockJS(); // SockJS 사용가능 설정
    }

    // 메시지 브로커를 구성하는 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //registry.enableSimpleBroker("/subscribe"); // /subscribe/{chatNo}로 주제 구독 가능,메시지 받을 때
        registry.setApplicationDestinationPrefixes("/app"); // /topic/message로 메시지 전송 컨트롤러 라우팅 가능, 메시지 보낼 때
    }

    // 클라이언트 인바운드 채널을 구성하는 메서드
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // stompHandler를 인터셉터로 등록하여 STOMP 메시지 핸들링을 수행
        registration.interceptors(stompHandler);
    }
}
