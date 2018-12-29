package com.Demo.pojo.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: zlf
 * @create: 2018-11-29 16:54
 **/
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "spring.redis")
@Component
@PropertySource(value = "classpath:application.yml")
public class RedisPojo implements ApplicationListener<ApplicationEvent> {

	@Value("${password}")
	private String password;

	@Value("${port}")
	private int port;

	@Value("${ip}")
	private String ip;

	@Value("${maxTotal}")
	private int maxTotal;

	@Value("${maxWaitMillis}")
	private int maxWaitMillis;

	@Value("${maxIdle}")
	private int maxIdle;

	@Value("${testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${testOnReturn}")
	private boolean testOnReturn;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	@Override
	public String toString() {
		return "RedisPojo{" +
				"password='" + password + '\'' +
				", port=" + port +
				", ip='" + ip + '\'' +
				", maxTotal=" + maxTotal +
				", maxWaitMillis=" + maxWaitMillis +
				", maxIdle=" + maxIdle +
				", testOnBorrow=" + testOnBorrow +
				", testOnReturn=" + testOnReturn +
				'}';
	}


	public void onApplicationEvent(ApplicationEvent event) {
		// 打印属性
		System.out.println("============= redisConnect ================" + event.getSource());
		System.out.println(this.toString());
	}
}
