package com.ALP.springbootwebsocketsample.wsmanagement;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class TextWebSocketHandlerImpl extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        super.afterConnectionEstablished(webSocketSession);
        webSocketSession.sendMessage(new TextMessage("Hello, welcome to spring-boot-websocket-sample!"));
        System.out.println("Connection established, session ID = " + webSocketSession.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        super.afterConnectionClosed(webSocketSession,closeStatus);
        System.out.println("Connection closed, session ID = " + webSocketSession.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session,message);
        System.out.println("input message : " + message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        super.handleTransportError(webSocketSession,throwable);
        System.out.println("Transport error : " + throwable.getMessage());
    }

}
