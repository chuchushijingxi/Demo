package com.Demo.config.webSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: CBL
 * @description:
 * @Date: 2018-05-21 11:21
 */
@ServerEndpoint(value = "/noToken/noReceive", configurator = GetHttpSessionConfigurator.class)
@Component
public class MyWebSocket {

	private static final Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

	private static CopyOnWriteArraySet<MyWebSocket> sessions = new CopyOnWriteArraySet<MyWebSocket>();

	private Session wsSession;
	private HttpSession httpSession;


	/*
		/**
		 * 连接建立成功调用的方法
		 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws Exception {
		logger.info("websocket open");
		this.wsSession = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		sessions.add(this);
	}


	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message) throws Exception {
		sendMessage(message, wsSession);
	}

	@OnClose
	public void onClose() {
		sessions.remove(this);
	}


	public void sendMessage(String msg, Session session) throws Exception {
		TestThread testThread = new TestThread(session);
		testThread.start();
	}


}
