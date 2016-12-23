package com.sovathana.controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.sovathana.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lunsovathana on 12/23/16.
 */
@Component
public class SocketChatController {

    private SocketIONamespace socketIONamespace;

    @Autowired
    public SocketChatController(SocketIOServer socketIOServer){
        this.socketIONamespace = socketIOServer.addNamespace("/chat");

        // onConnect
        this.socketIONamespace.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("Client Connected: " + socketIOClient);
            }
        });

        // onDisconnect
        this.socketIONamespace.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient socketIOClient) {
                System.out.println("Client Disconnected: " + socketIOClient);
            }
        });

        // onSend
        this.socketIONamespace.addEventListener("onSend", Message.class, new DataListener<Message>() {
            @Override
            public void onData(SocketIOClient socketIOClient, Message data, AckRequest ackRequest) throws Exception {
                System.out.println(String.format("%s send %s", data.getSenderName(), data.getText()));
            }
        });

    }

}
