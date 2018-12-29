package com.Demo.config.redis;

import com.Demo.pojo.redis.RedisPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class MyJedisPool implements CommandLineRunner {

	private static JedisPool pool;
	private static RedisPojo redisPojo;

	@Autowired
	public void setRedisPojo(RedisPojo redisPojo) {
		MyJedisPool.redisPojo = redisPojo;
	}

	@Override
	public void run(String... args) {
		// 创建jedis池配置实例
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置池配置项值
		config.setMaxTotal(Integer.valueOf(redisPojo.getMaxTotal()));
		config.setMaxIdle(Integer.valueOf(redisPojo.getMaxIdle()));
		config.setMaxWaitMillis(Long.valueOf(redisPojo.getMaxWaitMillis()));
		config.setTestOnBorrow(Boolean.valueOf(redisPojo.isTestOnBorrow()));
		config.setTestOnReturn(Boolean.valueOf(redisPojo.isTestOnReturn()));
		// 根据配置实例化jedis池
		pool = new JedisPool(config, redisPojo.getIp(),
				Integer.valueOf(redisPojo.getPort()));
	}

	/**
	 * 获得jedis对象
	 */
	public static synchronized Jedis getJedisObject() {
		Jedis jedis = pool.getResource();
		String password = redisPojo.getPassword();
		jedis.auth(password);
		return jedis;
	}

	/**
	 * 归还jedis对象
	 */
	public static void recycleJedisOjbect(Jedis jedis) {
		if (jedis != null)
			jedis.close();
	}

	public static void main(String[] args) {
		Jedis jedis = getJedisObject();
		jedis.set("1", "ce");
		recycleJedisOjbect(jedis);
	}

}