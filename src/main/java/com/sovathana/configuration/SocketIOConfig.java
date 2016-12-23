package com.sovathana.configuration;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lunsovathana on 12/23/16.
 */
@Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer(){
        SocketIOServer socketIOServer = new SocketIOServer(serverConfig());
        socketIOServer.start();
        return socketIOServer;
    }

    @Bean
    public com.corundumstudio.socketio.Configuration serverConfig(){
        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        /* Set WebSocket IP and Port */
        configuration.setHostname("localhost");
        configuration.setPort(2222);
        return  configuration;
    }

}
