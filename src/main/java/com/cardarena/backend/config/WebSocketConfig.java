package com.cardarena.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
class WebSocketConfig implements WebSocketConfigurer {

    private final EngineIoHandler mEngineIoHandler;

    public WebSocketConfig(EngineIoHandler engineIoHandler) {
        mEngineIoHandler = engineIoHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(mEngineIoHandler, "socket.io/*")
            .setAllowedOriginPatterns("*")
            .addInterceptors(mEngineIoHandler);
    }

}
