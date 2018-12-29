package com.Demo.config.webSocket;

import org.springframework.context.ApplicationContext;

import javax.websocket.Session;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-29 17:11
 **/
public class TestThread extends Thread {

	private static ApplicationContext applicationContext;

	private Session session;

	TestThread(Session session) {
		this.session = session;
	}

	public static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	@Override
	public void run() {
		int a = 0;
		while (true) {
			try {
				if (session != null && session.isOpen()) {
					session.getBasicRemote().sendText(++a + "");
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
