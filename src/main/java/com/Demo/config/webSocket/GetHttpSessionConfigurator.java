package com.Demo.config.webSocket;

/**
 * @author: CBL
 * @description:
 * @Date: 2018-05-28 18:36
 */
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator
{
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession session = (HttpSession) request.getHttpSession();//session有可能为空
        if (session!=null){
            sec.getUserProperties().put(HttpSession.class.getName(),session);
        }
    }
}